package com.mx.santander.lh.obpymes.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mx.santander.lh.obpymes.entities.Conditions;


public interface ConditionsRepository extends MongoRepository<Conditions, String>{

}
