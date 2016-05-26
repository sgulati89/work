package com.spark.data.ingester;

import java.util.HashMap;

import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.DataFrame;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SQLContext;

import com.spark.data.Assets.ASSETS;
import com.spark.data.util.Constants;

public class DataProcessor {

	public static void main(String[] args) throws Exception {
		// Map variables
		// TODO Not checking variables as the same is being done in script

		String hdfsInputPath = args[0];
		String fileFormat = args[1];
		String fileDefination = args[2]; // TODO not using as of now
		String outputPath = args[3];
		String partitionFormat = args[4];
		String errorPath = args[5];

		String formatClass = null;
		Row[] rowsInXml = null;
		Row[] rowsProcessed = null;

		outputPath = outputPath + "/" + partitionFormat;
		errorPath = errorPath + "/" + partitionFormat;

		Logger rootLogger = LogManager.getRootLogger();
		rootLogger.setLevel(Level.INFO);
		rootLogger.info("Input Path is: " + hdfsInputPath);
		rootLogger.info("Output Path is: " + outputPath);
		rootLogger.info("Error Path is: " + errorPath);
		// System.setProperty("hadoop.home.dir","C:\\Users\\sumit.kumar\\Docker\\winutil\\");
		SparkConf conf = new SparkConf().setAppName("DataProcessor").setMaster("local[*]");
		JavaSparkContext javaSparkContext = new JavaSparkContext(conf);
		SQLContext sqlContext = new SQLContext(javaSparkContext);
		DataFrame docDF = null;
		if (fileFormat.trim().toLowerCase().equalsIgnoreCase(Constants.XML)) {
			formatClass = "com.databricks.spark.xml";
			HashMap<String, String> params = new HashMap<String, String>();
			params.put("rowTag", "ASSETS");
			// params.put("failFast", "true");
			docDF = sqlContext.read().format(formatClass).options(params).load(hdfsInputPath);
		} else if (fileFormat.trim().toLowerCase().equalsIgnoreCase(Constants.JSON)) {
			formatClass = "org.apache.spark.sql.json";
			// asset = sqlContext.read().json(filePath);
			docDF = sqlContext.read().format(formatClass).load(hdfsInputPath);
		} else if (fileFormat.trim().toLowerCase().equalsIgnoreCase(Constants.CSV)) {
			formatClass = "com.databricks.spark.csv";
			docDF = sqlContext.read().format(formatClass).option("header", "true") // Use
																					// first
																					// line
																					// of
																					// all
																					// files
																					// as
																					// header
					.option("inferSchema", "true") // Automatically infer data
													// types
					.load(hdfsInputPath);
		} else if (fileFormat.trim().toLowerCase().equalsIgnoreCase(Constants.DELIMITED)) {
			formatClass = "com.databricks.spark.csv";
			docDF = sqlContext.read().format(formatClass).option("header", "true") // Use
																					// first
																					// line
																					// of
																					// all
																					// files
																					// as
																					// header
					.option("inferSchema", "true") // Automatically infer data
													// types
					.option("delimiter", "~") // TODO to be made configurable
												// later
					.load(hdfsInputPath);
		}

		docDF.printSchema();
		// TODO fetching file name dynamically is not working
		/*
		 * String[] fileArr=docDF.inputFiles(); for(String fil:fileArr){
		 * System.out.println("The file names are" +fil); }
		 */

		// Schema structure format

		System.out.println(docDF.schema().simpleString());

		Dataset<ASSETS> dataS = docDF.as(Encoders.bean(ASSETS.class));
		// checking
		dataS.show();

		// TODO to check how to fetch data using dataset
		// dataS.select();
		String query = "FhlmcModel_BND_CORP.PMT_LOCATION,  FhlmcModel_BND_CORP.ISSUE_YIELD,  FhlmcModel_BND_CORP.CHANGE_DT,  private ISSUE_EXCHANGES_set ISSUE_EXCHANGES_set,  "
				+ "FhlmcModel_BND_CORP.PMT_FREQ_TYPE,  FhlmcModel_BND_CORP.ISSUER_ID,  FhlmcModel_BND_CORP.ISSUE_DT,  FhlmcModel_BND_CORP.FLAG_CONVERT, "
				+ " FhlmcModel_BND_CORP.SAL_INDUSTRY,  FhlmcModel_BND_CORP.FLAG_EOM,  FhlmcModel_BND_CORP.MIN_TRD_SIZE,  FhlmcModel_BND_CORP.MIN_LOT_SIZE,"
				+ "  FhlmcModel_BND_CORP.COMPOUND_FLAG,  FhlmcModel_BND_CORP.PMT_CAL,  FhlmcModel_BND_CORP.SM_SEC_TYPE,  private SECTOR_set SECTOR_set, "
				+ " FhlmcModel_BND_CORP.PUT_CALL,  FhlmcModel_BND_CORP.MODIFIED_BY,  FhlmcModel_BND_CORP.STRUCTURE,  FhlmcModel_BND_CORP.REVIEWED_BY, "
				+ " FhlmcModel_BND_CORP.NTL_FLAG,  FhlmcModel_BND_CORP.FIRST_PAY_DT,  FhlmcModel_BND_CORP.UNITS,  FhlmcModel_BND_CORP.WI_FLAG, "
				+ " FhlmcModel_BND_CORP.END_ADJ_FLAG,  FhlmcModel_BND_CORP.CUSIP_TYPE,  FhlmcModel_BND_CORP.CPN_TYPE,  FhlmcModel_BND_CORP.CUSIP,  "
				+ "FhlmcModel_BND_CORP.FLAG_PERFORMING,  FhlmcModel_BND_CORP.DESC_INSTMT,  FhlmcModel_BND_CORP.SEC_TYPE,  FhlmcModel_BND_CORP.COUP_FREQ, "
				+ " private CUSIP2_set CUSIP2_set,  private NOTES_set NOTES_set,  private CUSIP_ALIAS_set CUSIP_ALIAS_set,  FhlmcModel_BND_CORP.ROUND_FLAG,  "
				+ "FhlmcModel_BND_CORP.MARKET,  private RATING_set RATING_set,  FhlmcModel_BND_CORP.LAST_REGULAR_PMT,  FhlmcModel_BND_CORP.TICKER,  "
				+ "FhlmcModel_BND_CORP.PRICE_AS_PCT,  FhlmcModel_BND_CORP.COUPON_FIX,  FhlmcModel_BND_CORP.FLAG_REG_RIGHTS,  FhlmcModel_BND_CORP.LIQUIDITY, "
				+ " FhlmcModel_BND_CORP.DATE_CONV,  FhlmcModel_BND_CORP.MARKET_ISSUE,  FhlmcModel_BND_CORP.LEAD_MGR,  FhlmcModel_BND_CORP.ACCRUAL_DT,  "
				+ "FhlmcModel_BND_CORP.CD_INSTMT_TYPE,  private UDF_set UDF_set,  FhlmcModel_BND_CORP.COUNTRY,  FhlmcModel_BND_CORP.ISSUE_PRICE, "
				+ " FhlmcModel_BND_CORP.ANNOUNCE_DT,  FhlmcModel_BND_CORP.ROUND_PRECISION,  FhlmcModel_BND_CORP.SM_SEC_GROUP,  FhlmcModel_BND_CORP.CALC_TYPE, "
				+ " FhlmcModel_BND_CORP.CURRENCY,  FhlmcModel_BND_CORP.MATURITY,  FhlmcModel_BND_CORP.FIRST_SETTLE_DT,  FhlmcModel_BND_CORP.FLAG_ERISA,"
				+ "  private Byte AMT_ISU,  FhlmcModel_BND_CORP.LEH_INDUSTRY,  FhlmcModel_BND_CORP.MTN,  FhlmcModel_BND_CORP.SETTLE_LOCATION, "
				+ " FhlmcModel_BND_CORP.FLAG_144A,  FhlmcModel_BND_CORP.PMT_ADJ_METH";

		DataFrame assets = dataS.toDF().cache();
		assets.registerTempTable("ASSETS");
		// DataFrame flatRec=docDF.select(
		// "FhlmcModel_BND_CORP.PMT_LOCATION","FhlmcModel_BND_CORP.ISSUE_YIELD"
		// );
		// DataFrame
		// flatRec=dataS.toDF().select(org.apache.spark.sql.functions.explode(docDF.col("FhlmcModel_BND_CORP")).as("FhlmcModel_FLAT")
		// );

		rowsInXml = assets.select("@RECORDS").collect();
		System.out.println("The count of rows in parent DF is :: " + rowsInXml[0].getLong(0));
		System.out.println("The row count is :" + rowsInXml[0].getLong(0));

		assets.show();

		DataFrame fhlmcModel_EX = sqlContext.sql("SELECT explode(ASSET.FhlmcModel_BND_CORP) as FhlmcModel_EX from ASSETS");
		fhlmcModel_EX.show();

		DataFrame exp_col = fhlmcModel_EX.select("FhlmcModel_EX.*");
		exp_col.show();
		Long rowsProcess = exp_col.count();
		System.out.println("The count of rows in dataset formatted DF is :: " + rowsProcess.longValue());

		if (rowsProcess.longValue() == rowsInXml[0].getLong(0)) {
			// Save File
			exp_col.write().format("parquet").mode("overwrite").save(outputPath + "/" + "fileName");
		} else {
			exp_col.write().format("parquet").mode("overwrite").save(errorPath + "/" + "fileName");
			System.out.println("Saved in Error folder as number of Rows did not match!!!");
			throw new Exception("Number of Rows did not match!!!");
		}

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

}
