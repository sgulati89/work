package com.spark;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.DataFrame;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SQLContext;

public class SparkTest {
	public static void main(String[] args) {

		SparkConf conf = new SparkConf().setMaster("local").setAppName("appName");
		JavaSparkContext javaSparkContext = new JavaSparkContext(conf);
		SQLContext sqlContext = new SQLContext(javaSparkContext);

		DataFrame asset = sqlContext.read().format("com.databricks.spark.xml").option("rowTag", "ASSET")
				.load("/home/impadmin/Documents/spark-sml/sample.xml");

		for (Row r : asset.collect()) {
			System.out.println(r.toString());
		}

		/*
		 * asset.registerTempTable("test"); DataFrame sql =
		 * sqlContext.sql("select * from test"); sql.show();
		 */

	}
}
