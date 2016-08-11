package com.mx.santander.lh.obpymes.dto;

public class ErrorDTO {
	
	String fieldCode;
	
	String message;

	public ErrorDTO(String fieldCode, String message) {
		this.message=message;
		this.fieldCode=fieldCode;
	}

	public String getFieldCode() {
		return fieldCode;
	}

	public void setFieldCode(String fieldCode) {
		this.fieldCode = fieldCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
