package com.demo.spring.mongo.spark;

import static java.lang.System.exit;

import org.apache.spark.api.java.JavaSparkContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class SpringBootConsoleApplication implements CommandLineRunner {

	@Autowired
	private DataService dataService;
	
	@Autowired
	private JavaSparkContext jsc;

	public static void main(String[] args) throws Exception {
		System.setProperty("hadoop.home.dir", "E:\\usr\\shared\\hadoop");
		// disabled banner, don't want to see the spring logo
		SpringApplication app = new SpringApplication(SpringBootConsoleApplication.class);
		app.setBannerMode(Banner.Mode.OFF);
		app.run(args);

	}

	@Override
	public void run(String... args) throws Exception {

		String sno = "16650088540";
		log.info("serialnumber={}, duration={}", sno, dataService.getDuration(sno));
		sno = "85577463420";
		log.info("serialnumber={}, duration={}", sno, dataService.getDuration(sno));

		jsc.close();
		exit(0);
	}
}