package com.mx.santander.lh.obpymes.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.validation.Valid;


import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.mx.santander.lh.obpymes.dto.ErrorDTO;
import com.mx.santander.lh.obpymes.input.SecurityCodeNewIN;
import com.mx.santander.lh.obpymes.input.SecurityCodeValidIN;
import com.mx.santander.lh.obpymes.output.SecurityCodeOUT;



@RestController
@RequestMapping(value = "/securityCode")
public class SecurityCodeController {
	
	@CrossOrigin
	@RequestMapping(value="/new", method = RequestMethod.POST)
	public SecurityCodeOUT validaDatos(@Valid @RequestBody SecurityCodeNewIN phoneNumber){
		SecurityCodeOUT securityCodeOUT=new SecurityCodeOUT();
		securityCodeOUT.setCode("200");
		return securityCodeOUT;
	
	}
	
	@CrossOrigin
	@RequestMapping(value="/valid", method = RequestMethod.POST)
	public SecurityCodeOUT validaDatos(@Valid @RequestBody SecurityCodeValidIN securityCode){
		SecurityCodeOUT securityCodeOUT=new SecurityCodeOUT();
		securityCodeOUT.setCode("200");
		return securityCodeOUT;
	
	}
	
	
	  @ExceptionHandler(MethodArgumentNotValidException.class)
	    
	    
	    public ResponseEntity<Object>  processValidationError(MethodArgumentNotValidException ex) {
	        BindingResult result = ex.getBindingResult();
	        List<FieldError> fieldErrors = result.getFieldErrors();
	        SecurityCodeOUT securityCodeOUT=new SecurityCodeOUT();
	        List<ErrorDTO> errors=new ArrayList<ErrorDTO>();
	        for(FieldError fieldError:fieldErrors){
	        	errors.add(new ErrorDTO(fieldError.getField(), fieldError.getDefaultMessage()));
	        }
	        
	        securityCodeOUT.setCode("2");
	        securityCodeOUT.setBody(errors);
	        securityCodeOUT.setMessage("Validación incorrecta");
	        
	        return ResponseEntity.status(HttpStatus.OK).body(new Gson().toJson(securityCodeOUT));
	        
	    }
	 
	    
	 
	 
}
