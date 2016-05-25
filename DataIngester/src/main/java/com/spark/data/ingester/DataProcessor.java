package com.spark.data.ingester;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.DataFrame;
import org.apache.spark.sql.SQLContext;
import org.apache.spark.sql.expressions.Window;
import org.apache.spark.sql.expressions.WindowSpec;

import com.spark.data.util.Constants;

public class DataProcessor {


	public static void main(String[] args) {
		//Disable extra log
		Logger.getLogger("org").setLevel(Level.ERROR);
	    Logger.getLogger("akka").setLevel(Level.ERROR);
	    
	    //Map variables 
	    //TODO Not checking variables as the same is being done in script
		String hdfsInputPath=args[0];
		String fileFormat=args[1];
		String fileDefination=args[2]; //TODO not using as of now
		String outputPath=args[3];
		String partitionFormat=args[4];
		
		String formatClass=null;
		
		System.setProperty("hadoop.home.dir", "C:\\Users\\sumit.kumar\\Docker\\winutil\\");
		SparkConf conf = new SparkConf().setAppName("DataProcessor");
		JavaSparkContext javaSparkContext = new JavaSparkContext(conf);
		SQLContext sqlContext = new SQLContext(javaSparkContext);
		DataFrame docDF = null;
		if(fileFormat.trim().toLowerCase().equalsIgnoreCase(Constants.XML)){
			formatClass="com.databricks.spark.xml";
			docDF = sqlContext.read().format(formatClass).option("rowTag", "ASSET").load(hdfsInputPath);
		}else if(fileFormat.trim().toLowerCase().equalsIgnoreCase(Constants.JSON)){
			formatClass="org.apache.spark.sql.json";
			//asset = sqlContext.read().json(filePath);
			docDF = sqlContext.read().format(formatClass).load(hdfsInputPath);
		}else if(fileFormat.trim().toLowerCase().equalsIgnoreCase(Constants.CSV)){
			formatClass="com.databricks.spark.csv";
			docDF = sqlContext.read().format(formatClass) .option("header", "true")     // Use first line of all files as header
				    .option("inferSchema", "true")                                      // Automatically infer data types
				    .load(hdfsInputPath);
		}else if(fileFormat.trim().toLowerCase().equalsIgnoreCase(Constants.DELIMITED)){
			formatClass="com.databricks.spark.csv";
			docDF = sqlContext.read().format(formatClass) .option("header", "true")      // Use first line of all files as header
				    .option("inferSchema", "true")                                       // Automatically infer data types
				    .option("delimiter", "~")   //TODO to be made configurable later
				    .load(hdfsInputPath);
		}
		

		docDF.printSchema();
		
		String[] fileArr=docDF.inputFiles();
		for(String fil:fileArr){
			System.out.println("The file names are" +fil);
		}
		System.out.println(docDF.schema().simpleString());
		docDF.write().format("parquet").mode("overwrite").save(outputPath+partitionFormat+fileArr[0]);
      
        
  //	asset.registerTempTable("asset_table");
  //	sqlContext.cacheTable("asset_table");
   //   DataFrame flatRec=docDF.select(docDF.col( "name").as("NAMES"),org.apache.spark.sql.functions.explode(docDF.col("schools")).as("schools_flat") );
      
   //   flatRec.show();
      
   //   DataFrame indvFlatRec=flatRec.select(flatRec.col("NAMES").as("NAM"),flatRec.col("schools_flat").getField("sname").as("schoolName"),flatRec.col("schools_flat").getField("year").as("schoolYear"));
    		  
    // indvFlatRec.;
   //  indvFlatRec.show();
    
    
     //Dataset

	}

}
