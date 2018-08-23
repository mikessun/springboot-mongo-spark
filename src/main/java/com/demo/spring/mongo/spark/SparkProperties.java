package com.demo.spring.mongo.spark;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

@ConfigurationProperties(prefix = "spark")
@Configuration
@Setter
@Getter
public class SparkProperties {
	private String masterUri;
	private String inputUriName;
	private String outputUriName;
	private String homeDir;
}
