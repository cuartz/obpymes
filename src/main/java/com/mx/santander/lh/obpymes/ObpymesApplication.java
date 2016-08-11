	package com.mx.santander.lh.obpymes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.retry.annotation.EnableRetry;

@EnableRetry
@SpringBootApplication
@ComponentScan(basePackages={"com.mx.santander.lh.obpymes"})
@EnableAutoConfiguration
@EnableMongoRepositories
public class ObpymesApplication {

	public static void main(String[] args) {
				SpringApplication.run(ObpymesApplication.class, args);
	}
}
