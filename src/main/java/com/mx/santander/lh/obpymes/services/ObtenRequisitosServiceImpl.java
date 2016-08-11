package com.mx.santander.lh.obpymes.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.santander.lh.obpymes.entities.Requirements;
import com.mx.santander.lh.obpymes.excepciones.ObPymeServiceException;
import com.mx.santander.lh.obpymes.repository.ConditionsRepository;
import com.mx.santander.lh.obpymes.repository.ConfigurableParametersRepository;
import com.mx.santander.lh.obpymes.repository.RequiredDocumentsRepository;


@Service
public class ObtenRequisitosServiceImpl implements ObtenRequisitosService{

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	ConditionsRepository conditionsRepository;
	
	@Autowired
	ConfigurableParametersRepository configurableParametersRepository;
	
	@Autowired
	RequiredDocumentsRepository requiredDocumentsRepository;
	
	
	
	public Requirements getRequisitos() throws ObPymeServiceException{
		logger.info("Intentos");
		Requirements requisitos=new Requirements();
		requisitos.setConditions(conditionsRepository.findAll());
		requisitos.setDocuments(requiredDocumentsRepository.findAll());
		requisitos.setDays(configurableParametersRepository.findByName("DaysToInactive").getValue());
		return requisitos;
	}

}
