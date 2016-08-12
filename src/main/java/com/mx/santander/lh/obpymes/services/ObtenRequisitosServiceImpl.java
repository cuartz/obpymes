package com.mx.santander.lh.obpymes.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.santander.lh.obpymes.entities.Conditions;
import com.mx.santander.lh.obpymes.entities.ConfigurableParameters;
import com.mx.santander.lh.obpymes.entities.Documents;
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
	
	
	
	public Requirements getRequirements() throws ObPymeServiceException{
		logger.info("Intentos");
		Requirements requisitos=new Requirements();
		requisitos.setConditions(conditionsRepository.findAll());
		requisitos.setDocuments(requiredDocumentsRepository.findAll());
		requisitos.setDays(configurableParametersRepository.findByName("DaysToInactive").getValue());
		return requisitos;
	}
	
	public List<Conditions> getConditions() throws ObPymeServiceException{
		logger.info("Intentosc conds");
		return conditionsRepository.findAll();
	}
	
	public List<Documents> getDocuments() throws ObPymeServiceException{
		logger.info("Intentos docs");
		return requiredDocumentsRepository.findAll();
	}
	
	public String getDays() throws ObPymeServiceException{
		logger.info("Intentos days");
		ConfigurableParameters configurableParameters=(configurableParametersRepository.findByName("DaysToInactive"));
		if(configurableParameters!=null){
			return configurableParameters.getValue();
		}
		throw new ObPymeServiceException();
		
	}

}
