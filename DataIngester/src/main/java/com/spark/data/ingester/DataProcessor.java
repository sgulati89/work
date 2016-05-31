package com.spark.data.ingester;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.broadcast.Broadcast;
import org.apache.spark.sql.DataFrame;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SQLContext;

import com.spark.data.Assets.ASSET;
import com.spark.data.Assets.ASSETS;
import com.spark.data.util.Constants;

public class DataProcessor implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	transient static Logger rootLogger = LogManager.getLogger("myLogger");

	public static void main(String[] args) throws Exception {
		// Map variables
		// TODO Not checking variables as the same is being done in script

		String hdfsInputPath = args[0];
		String fileFormat = args[1];
		String fileDefination = args[2]; // TODO not using as of now
		String outputPath = args[3];
		String partitionFormat = args[4];
		String errorPath = args[5];
		String schemaPath=args[6];
		String rowTag=args[7];

		String formatClass = null;
		Row[] rowsInXml = null;
		Row[] rowsProcessed = null;

		outputPath = outputPath + "/" + partitionFormat;
		errorPath = errorPath + "/" + partitionFormat;

		//Logger rootLogger = LogManager.getRootLogger();
		//rootLogger.setLevel(Level.INFO);
		rootLogger.info("Input Path is: " + hdfsInputPath);
		rootLogger.info("Output Path is: " + outputPath);
		rootLogger.info("Error Path is: " + errorPath);
	   System.setProperty("hadoop.home.dir","C:\\Users\\sumit.kumar\\Docker\\winutil\\");
		SparkConf conf = new SparkConf().setAppName("DataProcessor").setMaster("local[*]");
		JavaSparkContext javaSparkContext = new JavaSparkContext(conf);
		SQLContext sqlContext = new SQLContext(javaSparkContext);
		DataFrame docDF = null;
		if (fileFormat.trim().toLowerCase().equalsIgnoreCase(Constants.XML)) {
			formatClass = "com.databricks.spark.xml";
			HashMap<String, String> params = new HashMap<String, String>();
			params.put("rowTag", rowTag);
			// params.put("failFast", "true");
			docDF = sqlContext.read().format(formatClass).options(params).load(hdfsInputPath);
		} else if (fileFormat.trim().toLowerCase().equalsIgnoreCase(Constants.JSON)) {
			formatClass = "org.apache.spark.sql.json";
			// asset = sqlContext.read().json(filePath);
			docDF = sqlContext.read().format(formatClass).load(hdfsInputPath);
		} else if (fileFormat.trim().toLowerCase().equalsIgnoreCase(Constants.CSV)) {
			formatClass = "com.databricks.spark.csv";
			docDF = sqlContext.read().format(formatClass).option("header", "true") // Use first line of all files as header
					.option("inferSchema", "true") // Automatically infer data types
					.load(hdfsInputPath);
		} else if (fileFormat.trim().toLowerCase().equalsIgnoreCase(Constants.DELIMITED)) {
			formatClass = "com.databricks.spark.csv";
			docDF = sqlContext.read().format(formatClass).option("header", "true") // Use first line of all files as header
					.option("inferSchema", "true") // Automatically infer data types
					.option("delimiter", "~") // TODO to be made configurable later
					.load(hdfsInputPath);
		}

		docDF.printSchema();
		
		 final Broadcast<String> schemaString = javaSparkContext.broadcast(loadSchema(schemaPath));
		// TODO fetching file name dynamically is not working
		/*
		 * String[] fileArr=docDF.inputFiles(); for(String fil:fileArr){
		 * rootLogger.info("The file names are" +fil); }
		 */

		// Schema structure format

		rootLogger.info(docDF.schema().simpleString());

	//	Dataset<ASSET> dataS = docDF.as(Encoders.bean(ASSET.class));
		// checking
	//	dataS.show();

		// TODO to check how to fetch data using dataset
		// dataS.select();
		
		DataFrame assets = docDF;
		assets.registerTempTable(rowTag);
		// DataFrame flatRec=docDF.select(
		// "FhlmcModel_BND_CORP.PMT_LOCATION","FhlmcModel_BND_CORP.ISSUE_YIELD"
		// );
		// DataFrame
		// flatRec=dataS.toDF().select(org.apache.spark.sql.functions.explode(docDF.col("FhlmcModel_BND_CORP")).as("FhlmcModel_FLAT")
		// );

		//rowsInXml = assets.select("@RECORDS").collect();
		//rootLogger.info("The count of rows in parent DF is :: " + rowsInXml[0].getLong(0));
		//rootLogger.info("The row count is :" + rowsInXml[0].getLong(0));

		assets.show();
		rootLogger.info("The Schema structure in which data needs to be stored is "+schemaString.getValue());
		DataFrame exSchemaDF = sqlContext.sql("select "+schemaString.getValue()+" from "+rowTag);
		exSchemaDF.show();

		//DataFrame exp_col = fhlmcModel_EX.select("FhlmcModel_EX.*");
		//exp_col.show();
		//Long rowsProcess = exp_col.count();
		//rootLogger.info("The count of rows in dataset formatted DF is :: " + rowsProcess.longValue());

		//if (rowsProcess.longValue() == rowsInXml[0].getLong(0)) {
			// Save File
		exSchemaDF.write().format("parquet").mode("overwrite").save(outputPath);
		//} else {
		//	exp_col.write().format("parquet").mode("overwrite").save(errorPath + "/" + "fileName");
		//	rootLogger.info("Saved in Error folder as number of Rows did not match!!!");
		//	throw new Exception("Number of Rows did not match!!!");
		//}

		// createDataset(docDF.t, Encoders.bean(ASSETS.class)) ;

		// asset.registerTempTable("asset_table");
		// sqlContext.cacheTable("asset_table");
		// DataFrame flatRec=docDF.select(docDF.col(
		// "name").as("NAMES"),org.apache.spark.sql.functions.explode(docDF.col("schools")).as("schools_flat")
		// );

		// flatRec.show();

		// DataFrame
		// indvFlatRec=flatRec.select(flatRec.col("NAMES").as("NAM"),flatRec.col("schools_flat").getField("sname").as("schoolName"),flatRec.col("schools_flat").getField("year").as("schoolYear"));

		// indvFlatRec.;
		// indvFlatRec.show();

	}
	static String loadSchema(String schemaPath) throws FileNotFoundException {
	    Scanner callSignTbl = new Scanner(new File("E:\\tested\\selectStatement.txt"));
	   // ArrayList<String> callSignList = new ArrayList<String>();
	    StringBuffer callString=new StringBuffer();
	    while (callSignTbl.hasNextLine()) {
	     // callSignList.add(callSignTbl.nextLine());
	    	callString.append(callSignTbl.nextLine().trim()+" , ");
	    }
	    callSignTbl.close();
	    return callString.toString().substring(0,callString.toString().length()-2);
	  }
}
