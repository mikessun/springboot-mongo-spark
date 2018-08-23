package com.demo.spring.mongo.spark;

import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongodb.spark.MongoSpark;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class QueryDataService {

	@Autowired
	private JavaSparkContext jsc;

	@Autowired
	private SparkSession sparkSession;

	public double queryData(String sno) {
		log.info("IN queryData for sNo={}, ", sno);
		Dataset<Row> implicitDS = MongoSpark.load(jsc).toDF();
		
		implicitDS.printSchema();
		implicitDS.show();	

		// Create the temp view and execute the query
		implicitDS.createOrReplaceTempView("summary_data_ts");
		Dataset<Row> resultDataSet = sparkSession
				.sql("SELECT sum(Val_Duration) as usage FROM summary_data_ts WHERE FG_SerialNo = '" + sno + "'");
		resultDataSet.show();

		return resultDataSet.select("usage").first().getDouble(0);
	}
}
