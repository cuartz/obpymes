package com.mx.santander.lh.obpymes.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mx.santander.lh.obpymes.entities.Documents;


public interface RequiredDocumentsRepository extends MongoRepository<Documents, String>{

}
