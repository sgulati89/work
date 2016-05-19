package com.spark;

import java.util.ArrayList;
import java.util.List;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.VoidFunction;
import org.apache.spark.sql.DataFrame;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SQLContext;
import org.apache.spark.sql.types.DataType;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.Metadata;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.StructType;

public class SparkTest {
	public static void main(String[] args) {

		SparkConf conf = new SparkConf().setMaster("local").setAppName("appName");
		JavaSparkContext javaSparkContext = new JavaSparkContext(conf);
		SQLContext sqlContext = new SQLContext(javaSparkContext);

		List<StructField>  ceList =new ArrayList<>();
		ceList.add(DataTypes.createStructField("CONDITIONAL", DataTypes.StringType, true));
		ceList.add(DataTypes.createStructField("MATURITY", DataTypes.StringType, true));
		ceList.add(DataTypes.createStructField("PCT", DataTypes.StringType, true));
		ceList.add(DataTypes.createStructField("PROVIDER", DataTypes.StringType, true));
		ceList.add(DataTypes.createStructField("START_DATE", DataTypes.StringType, true));
		ceList.add(DataTypes.createStructField("TYPE", DataTypes.StringType, true));

		StructField[] ceSet=new StructField[] { new StructField("CE_record", DataTypes.createArrayType(DataTypes.createStructType(ceList),true), true, Metadata.empty())};
		
		List<StructField>  cusip2RecordList =new ArrayList<>();
		cusip2RecordList.add(DataTypes.createStructField("CODE", DataTypes.StringType, true));
		cusip2RecordList.add(DataTypes.createStructField("IDENTIFIER", DataTypes.StringType, true));
		
		StructField[] cusip2Record=new StructField[] { new StructField("CUSIP2_record", DataTypes.createArrayType(DataTypes.createStructType(cusip2RecordList),true), true, Metadata.empty())};
		
		
		List<StructField>  cusipAliasList =new ArrayList<>();
		cusipAliasList.add(DataTypes.createStructField("CODE", DataTypes.StringType, true));
		cusipAliasList.add(DataTypes.createStructField("IDENTIFIER", DataTypes.StringType, true));
		cusipAliasList.add(DataTypes.createStructField("PURPOSE", DataTypes.StringType, true));
		
		StructField[] cusipAlias=new StructField[] { new StructField("CUSIP_ALIAS_record", DataTypes.createArrayType(DataTypes.createStructType(cusipAliasList),true), true, Metadata.empty())};
		
		
		List<StructField>  issueExchSetList =new ArrayList<>();
		issueExchSetList.add(DataTypes.createStructField("EXCHANGE", DataTypes.StringType, true));
		
		StructField[] issueExchSet=new StructField[] { new StructField("ISSUE_EXCHANGES_record", DataTypes.createArrayType(DataTypes.createStructType(issueExchSetList),true), true, Metadata.empty())};
		
		
		List<StructField>  ratingSetList =new ArrayList<>();
		ratingSetList.add(DataTypes.createStructField("AGY", DataTypes.StringType, true));
		ratingSetList.add(DataTypes.createStructField("DATE", DataTypes.StringType, true));
		ratingSetList.add(DataTypes.createStructField("VALUE", DataTypes.StringType, true));
		
		StructField[] ratingSet=new StructField[] { new StructField("RATING_record", DataTypes.createArrayType(DataTypes.createStructType(ratingSetList),true), true, Metadata.empty())};
		
		
		
		List<StructField>  sectorSetList =new ArrayList<>();
		sectorSetList.add(DataTypes.createStructField("CODE", DataTypes.StringType, true));
		sectorSetList.add(DataTypes.createStructField("LEVEL", DataTypes.StringType, true));
		sectorSetList.add(DataTypes.createStructField("SECTOR_SOURCE", DataTypes.StringType, true));
		sectorSetList.add(DataTypes.createStructField("TYPE", DataTypes.StringType, true));
		
		StructField[] sectorSet=new StructField[] { new StructField("SECTOR_record", DataTypes.createArrayType(DataTypes.createStructType(sectorSetList),true), true, Metadata.empty())};
		
		
		
		
		List<StructField>  udfSetList =new ArrayList<>();
		udfSetList.add(DataTypes.createStructField("LABEL", DataTypes.StringType, true));
		udfSetList.add(DataTypes.createStructField("PURPOSE", DataTypes.StringType, true));
		udfSetList.add(DataTypes.createStructField("VALUE", DataTypes.StringType, true));
		
		StructField[] udfSet=new StructField[] { new StructField("UDF_record", DataTypes.createArrayType(DataTypes.createStructType(udfSetList),true), true, Metadata.empty())};
		
		
		
		
		StructType customSchema = new StructType(new StructField[] {
				new StructField("ACCRUAL_DT", DataTypes.StringType, true, Metadata.empty()),
				new StructField("AMT_ISU", DataTypes.StringType, true, Metadata.empty()),
				new StructField("ANNOUNCE_DT", DataTypes.StringType, true, Metadata.empty()),
				new StructField("CALC_TYPE", DataTypes.StringType, true, Metadata.empty()),
				new StructField("CD_INSTMT_TYPE", DataTypes.StringType, true, Metadata.empty()),
				new StructField("CE_set",DataTypes.createStructType(ceSet),true,Metadata.empty()),
				new StructField("CHANGE_DT", DataTypes.StringType, true, Metadata.empty()),
				
				new StructField("COMPOUND_FLAG", DataTypes.StringType, true, Metadata.empty()),
				new StructField("COUNTRY", DataTypes.StringType, true, Metadata.empty()),
				new StructField("COUPON_FIX", DataTypes.StringType, true, Metadata.empty()),
				new StructField("COUP_FREQ", DataTypes.StringType, true, Metadata.empty()),
				new StructField("CPN_TYPE", DataTypes.StringType, true, Metadata.empty()),
				new StructField("CURRENCY", DataTypes.StringType, true, Metadata.empty()),
				new StructField("CUSIP", DataTypes.StringType, true, Metadata.empty()),
				new StructField("CUSIP2_set", DataTypes.createStructType(cusip2Record), true, Metadata.empty()),
				new StructField("CUSIP_ALIAS_set", DataTypes.createStructType(cusipAlias), true, Metadata.empty()),
				new StructField("CUSIP_TYPE", DataTypes.StringType, true, Metadata.empty()),
				new StructField("DATE_CONV", DataTypes.StringType, true, Metadata.empty()),
				new StructField("DESC_INSTMT", DataTypes.StringType, true, Metadata.empty()),
				new StructField("END_ADJ_FLAG", DataTypes.StringType, true, Metadata.empty()),
				new StructField("FIRST_PAY_DT", DataTypes.StringType, true, Metadata.empty()),
				new StructField("FIRST_SETTLE_DT", DataTypes.StringType, true, Metadata.empty()),
				new StructField("FLAG_144A", DataTypes.StringType, true, Metadata.empty()),
				new StructField("FLAG_CONVERT", DataTypes.StringType, true, Metadata.empty()),
				new StructField("FLAG_EOM", DataTypes.StringType, true, Metadata.empty()),
				new StructField("FLAG_ERISA", DataTypes.StringType, true, Metadata.empty()),
				new StructField("FLAG_PERFORMING", DataTypes.StringType, true, Metadata.empty()),
				new StructField("FLAG_REG_RIGHTS", DataTypes.StringType, true, Metadata.empty()),
				new StructField("ISSUER_ID", DataTypes.StringType, true, Metadata.empty()),
				new StructField("ISSUE_DT", DataTypes.StringType, true, Metadata.empty()),
				new StructField("ISSUE_EXCHANGES_set", DataTypes.createStructType(issueExchSet), true, Metadata.empty()),
				new StructField("ISSUE_PRICE", DataTypes.StringType, true, Metadata.empty()),
				new StructField("LEH_INDUSTRY", DataTypes.StringType, true, Metadata.empty()),
				new StructField("LIQUIDITY", DataTypes.StringType, true, Metadata.empty()),
				new StructField("MARKET", DataTypes.StringType, true, Metadata.empty()),
				new StructField("MATURITY", DataTypes.StringType, true, Metadata.empty()),
				new StructField("MIN_LOT_SIZE", DataTypes.StringType, true, Metadata.empty()),
				new StructField("MIN_TRD_SIZE", DataTypes.StringType, true, Metadata.empty()),
				new StructField("MODIFIED_BY", DataTypes.StringType, true, Metadata.empty()),
				new StructField("MTN", DataTypes.StringType, true, Metadata.empty()),
				new StructField("NTL_FLAG", DataTypes.StringType, true, Metadata.empty()),
				new StructField("PMT_ADJ_METH", DataTypes.StringType, true, Metadata.empty()),
				new StructField("PMT_CAL", DataTypes.StringType, true, Metadata.empty()),
				new StructField("PMT_FREQ_TYPE", DataTypes.StringType, true, Metadata.empty()),
				new StructField("PMT_LOCATION", DataTypes.StringType, true, Metadata.empty()),
				new StructField("PRICE_AS_PCT", DataTypes.StringType, true, Metadata.empty()),
				new StructField("PUT_CALL", DataTypes.StringType, true, Metadata.empty()),
				new StructField("RATING_set", DataTypes.createStructType(ratingSet), true, Metadata.empty()),
				new StructField("REVIEWED_BY", DataTypes.StringType, true, Metadata.empty()),
				new StructField("ROUND_FLAG", DataTypes.StringType, true, Metadata.empty()),
				new StructField("ROUND_PRECISION", DataTypes.StringType, true, Metadata.empty()),
				new StructField("SAL_INDUSTRY", DataTypes.StringType, true, Metadata.empty()),
				new StructField("SECTOR_set", DataTypes.createStructType(sectorSet), true, Metadata.empty()),
				new StructField("SEC_TYPE", DataTypes.StringType, true, Metadata.empty()),
				new StructField("SETTLE_LOCATION", DataTypes.StringType, true, Metadata.empty()),
				new StructField("SM_SEC_GROUP", DataTypes.StringType, true, Metadata.empty()),
				new StructField("SM_SEC_TYPE", DataTypes.StringType, true, Metadata.empty()),
				new StructField("STRUCTURE", DataTypes.StringType, true, Metadata.empty()),
				new StructField("TICKER", DataTypes.StringType, true, Metadata.empty()),
				new StructField("UDF_set", DataTypes.createStructType(udfSet), true, Metadata.empty()),
				new StructField("UNITS", DataTypes.StringType, true, Metadata.empty()),
				new StructField("WI_FLAG", DataTypes.StringType, true, Metadata.empty())
			});
		
		
		DataFrame asset = sqlContext.read().format("com.databricks.spark.xml").option("rowTag", "FhlmcModel_BND_CORP").schema(customSchema).
			load("/home/impadmin/Documents/spark-sml/sample.xml");

		asset.registerTempTable("asset_table");
		DataFrame assetTable=sqlContext.sql("SELECT UNITS from asset_table");
		
		assetTable.write().format("parquet").mode("overwrite").save("hdfs://localhost:8020/user/impadmin/spark");

		//assetTable.write().format("parquet").mode("overwrite").save("/home/impadmin/Documents/spark-sml/out");
		assetTable.show();
		
		//assetTable.toJavaRDD().saveAsTextFile("hdfs://localhost:8020/user/impadmin/spark");

	}
}
