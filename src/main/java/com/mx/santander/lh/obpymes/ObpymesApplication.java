	package com.mx.santander.lh.obpymes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"com.mx.santander.lh.obpymes;com.mx.santander.lh.obpymes.repository;"})
@EnableAutoConfiguration
public class ObpymesApplication {

	public static void main(String[] args) {
				SpringApplication.run(ObpymesApplication.class, args);
	}
}
