package com.mx.santander.lh.obpymes.entities;


import java.util.List;

import com.mx.santander.lh.obpymes.excepciones.ObPymeServiceException;






public class Requirements {
	
	private List<Conditions> conditions;
	
	private List<Documents> documents;
	
	
	
	private String days;

	public List<Conditions> getConditions() {
		
		return conditions;
	}

	public List<Documents> getDocuments() {
		return documents;
	}

	

	

	public void setConditions(List<Conditions> conditions) {
		this.conditions=conditions;
		
	}

	public void setDocuments(List<Documents> documents) {
		this.documents=documents;
		
	}
	
	public void setDays(String days) throws ObPymeServiceException{
		this.days=days;
	}
	
	public String getDays() throws ObPymeServiceException{
		return days;
	}

	

}
