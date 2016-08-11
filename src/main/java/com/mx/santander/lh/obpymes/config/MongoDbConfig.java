package com.mx.santander.lh.obpymes.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.MongoURI;



@Configuration
@EnableMongoRepositories(basePackages = "com.mx.santander.lh.obpymes.repository")
public class MongoDbConfig extends AbstractMongoConfiguration {

	@Value("${url.mongo}")
	private String url;

	@Value("${db.mongo}")
	private String databaseName;

	@Override
	protected String getDatabaseName() {
		return databaseName;
	}

	@SuppressWarnings("deprecation")
	@Override
	public Mongo mongo() throws Exception {
		return new Mongo(new MongoURI(url));
	}

	@Override
	protected String getMappingBasePackage() {
		return "mx.curso.obpymes.mongo";
	}
}
