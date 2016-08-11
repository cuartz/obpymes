package com.mx.santander.lh.obpymes.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mx.santander.lh.obpymes.entities.ConfigurableParameters;


public interface ConfigurableParametersRepository extends MongoRepository<ConfigurableParameters, String>{
	
	public ConfigurableParameters findByName(String name);

}
