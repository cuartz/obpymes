package com.mx.santander.lh.obpymes.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.mx.santander.lh.obpymes.output.RequirementsControllerResponse;
import com.mx.santander.lh.obpymes.services.ObtenRequisitosService;
import com.mx.santander.lh.obpymes.entities.Requirements;
import com.mx.santander.lh.obpymes.excepciones.ObPymeServiceException;



@RestController
@RequestMapping(value = "/requirements")
public class RequirementsController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	ObtenRequisitosService obtenRequisitosService;
	
	@CrossOrigin
	@RequestMapping(value="/all", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> getRequirements(){
			
		try{
			RequirementsControllerResponse requirementsControllerResponse=new RequirementsControllerResponse();
			requirementsControllerResponse.setBody(obtenRequisitosService.getRequisitos());
			requirementsControllerResponse.setCode("200");
			logger.info("Requirement get succesful");
			logger.info(((Requirements)requirementsControllerResponse.getBody()).getDocuments().get(0).getContent());
			return ResponseEntity.status(HttpStatus.OK).body(new Gson().toJson(requirementsControllerResponse));
			
		}
		catch(ObPymeServiceException oe){
			RequirementsControllerResponse requirementsControllerResponse=new RequirementsControllerResponse();
			requirementsControllerResponse.setCode("1");
			requirementsControllerResponse.setMessage("No se pudieron recuperar los requisitos");
			return ResponseEntity.status(HttpStatus.OK).body(new Gson().toJson(requirementsControllerResponse));
		}
	}
	
	@CrossOrigin
	@RequestMapping(value="/documents", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> getRequirementsDocuments(){
		
		try{
			RequirementsControllerResponse requirementsControllerResponse=new RequirementsControllerResponse();
			requirementsControllerResponse.setBody(obtenRequisitosService.getDocumentos());
			requirementsControllerResponse.setCode("200");
			return ResponseEntity.status(HttpStatus.OK).body(new Gson().toJson(requirementsControllerResponse));
			
		}
		catch(ObPymeServiceException oe){
			RequirementsControllerResponse requirementsControllerResponse=new RequirementsControllerResponse();
			requirementsControllerResponse.setCode("1");
			requirementsControllerResponse.setMessage("No se pudieron recuperar los requisitos");
			return ResponseEntity.status(HttpStatus.OK).body(new Gson().toJson(requirementsControllerResponse));
		}
	}
	
	@CrossOrigin
	@RequestMapping(value="/conditions", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> getRequirementsConditions(){
		
		try{
			RequirementsControllerResponse requirementsControllerResponse=new RequirementsControllerResponse();
			requirementsControllerResponse.setBody(obtenRequisitosService.getComditions());
			requirementsControllerResponse.setCode("200");
			return ResponseEntity.status(HttpStatus.OK).body(new Gson().toJson(requirementsControllerResponse));
			
		}
		catch(ObPymeServiceException oe){
			RequirementsControllerResponse requirementsControllerResponse=new RequirementsControllerResponse();
			requirementsControllerResponse.setCode("1");
			requirementsControllerResponse.setMessage("No se pudieron recuperar los requisitos");
			return ResponseEntity.status(HttpStatus.OK).body(new Gson().toJson(requirementsControllerResponse));
		}
	}
	
	@CrossOrigin
	@RequestMapping(value="/days", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> getRequirementsDays(){
		
		try{
			RequirementsControllerResponse requirementsControllerResponse=new RequirementsControllerResponse();
			requirementsControllerResponse.setBody(obtenRequisitosService.getDays());
			requirementsControllerResponse.setCode("200");
			return ResponseEntity.status(HttpStatus.OK).body(new Gson().toJson(requirementsControllerResponse));
			
		}
		catch(ObPymeServiceException oe){
			RequirementsControllerResponse requirementsControllerResponse=new RequirementsControllerResponse();
			requirementsControllerResponse.setCode("1");
			requirementsControllerResponse.setMessage("No se pudieron recuperar los requisitos");
			return ResponseEntity.status(HttpStatus.OK).body(new Gson().toJson(requirementsControllerResponse));
		}
	}

}
