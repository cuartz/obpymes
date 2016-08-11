package com.mx.santander.lh.obpymes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.santander.lh.obpymes.entities.Requirements;
import com.mx.santander.lh.obpymes.excepciones.ObPymeServiceException;
import com.mx.santander.lh.obpymes.repository.ConditionsRepository;
import com.mx.santander.lh.obpymes.repository.ConfigurableParametersRepository;
import com.mx.santander.lh.obpymes.repository.RequiredDocumentsRepository;


@Service
public class ObtenRequisitosServiceImpl implements ObtenRequisitosService{


	@Autowired
	ConditionsRepository conditionsRepository;
	
	@Autowired
	ConfigurableParametersRepository configurableParametersRepository;
	
	@Autowired
	RequiredDocumentsRepository requiredDocumentsRepository;
	
	@Override
	public Requirements getRequisitos() throws ObPymeServiceException{
		Requirements requisitos=new Requirements();
		requisitos.setConditions(conditionsRepository.findAll());
		requisitos.setDocuments(requiredDocumentsRepository.findAll());
		requisitos.setDays(configurableParametersRepository.findByName("DaysToInactive").getValue());
		return requisitos;
	}

}
