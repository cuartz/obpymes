package com.mx.santander.lh.obpymes.input;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class SecurityCodeNewIN {

	@NotNull(message="El teléfono es requerido")
	@Pattern(regexp="([0-9]{10})", message="El teléfono debe ser de 10 dígitos y solo contener números")
	private String phoneNumber;
	@NotNull(message="El RFC es requerido")
	@Pattern(regexp="([A-Z]{3}[0-9]{6}[A-Z0-9]{3}|[A-Z]{4}[0-9]{6}[A-Z0-9]{3})", message="El RFC no es correcto")
	private String rfc;

	public SecurityCodeNewIN(){}
	
	public String getRfc() {
		return rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	public SecurityCodeNewIN(String rfc, String phoneNumber){
		this.rfc=rfc;
		this.phoneNumber=phoneNumber;
	}
	


	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		
		this.phoneNumber = phoneNumber;
	}

}
