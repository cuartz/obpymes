package com.mx.santander.lh.obpymes.output;

public class RequirementsControllerResponse {

	
	private Object body;
	private String code;
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getBody() {
		return body;
	}

	public void setBody(Object body) {
		this.body = body;
	}

	public void setCode(String code) {
		this.code=code;
		
	}

	public String getCode() {
		return code;
	}
	
	
	
}
