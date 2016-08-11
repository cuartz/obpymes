package com.mx.santander.lh.obpymes.controllers;


import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.messaging.handler.annotation.support.MethodArgumentNotValidException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR, reason="Server error")
	@ExceptionHandler(Exception.class)
	public String handleSQLException(HttpServletRequest request, Exception ex){
		logger.info("General exception="+request.getRequestURL());
		return "Server error";
	}

	

}