#!/bin/bash
#####################################################################################
# No. of Input Parameters   : 5
# Input Parameter accepted  : USAGE: <inputFilePath:string:required> <isLocalFile:boolean:required> <fileFormat:string:required > <fileDefination:string:required> <outputPath:string:required> <partitionFormat:string:optional>
# Output                    : Error/Success on Exit
# comments					: 
#####################################################################################
# Modification History
# Created By        Created on      Changes
# ----------------- --------------- ------------------------------------------------
# Sumit Kumar       	05/25/2016     Initial Version
#
#####################################################################################

USAGE="USAGE: <inputFilePath:string:required> <isLocalFile:boolean:required> <fileFormat:string:required > <fileDefination:string:required> <outputPath:string:required> <partitionFormat:string:optional> <errorPath:string:required> <schemaPath:string:required> <rowTag:string:required> "
#contants
HADOOP_BIN="/home/hadoop/hadoop/hadoop-2.6.4/bin"
SPARK_BIN="/home/hadoop/spark/spark-1.6.1-bin-hadoop2.6/bin"


#Variable assignment
inputFilePath=${1:-""}
isLocalFile=${2:-false}
fileFormat=${3:-"xml"}
fileDefination=${4:-""}
outputPath=${5:-""}
partitionFormat=${6:-""}
errorPath=${7:-""}
schemaPath=${8:-""}
rowTag=${9:-""}

hdfsInputPath=

#redirect all 
1>&2 

# check argument count
if [ $# -ge 4 && $# -le 9 ]
then
  echo $USAGE
  exit
else
  echo " ------------------: Spark Job started :----------------------"   
  echo " ------------------: $(date) :----------------------"
fi

#Copy local file to HDFS

if $isLocalFile
  then
    $HADOOP_BIN/hdfs dfs -put $inputFilePath $hdfsInputPath
	if [ "$?" = "0" ]
	then
	  echo "$(date) :: Successfully copied file from local path :: $inputFilePath to hdfs path :: $hdfsInputPath"  
    else
	  echo "$(date) :: !!!!!!!! Eorror occured !!!!! Copying local file to HDFS failed " 
	exit 1
   fi
fi  
  
#Launch Job
  
  
$SPARK_BIN/spark-submit \
--class com.spark.data.ingester.DataProcessor \
--master local[*] \
/home/hadoop/project/work/DataIngester/target/DataIngester-0.0.1-SNAPSHOT-jar-with-dependencies.jar \
$inputFilePath \
$fileFormat \
$fileDefination \
$outputPath \
$partitionFormat \
$errorPath

if [ "$?" = "0" ]
	then
	   echo "$(date) :: Spark Job completed successfully "  
	   echo " ------------------: Spark Job Finished :----------------------"   
       echo " ------------------: $(date) :----------------------"
    else
	  echo "$(date) :: !!!!!!!! Eorror occured !!!!! While executing Spark Job !!!!!!!!!!!!!! " 
	exit 1
fi
