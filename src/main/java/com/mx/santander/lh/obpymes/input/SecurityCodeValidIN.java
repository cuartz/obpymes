package com.mx.santander.lh.obpymes.input;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class SecurityCodeValidIN extends SecurityCodeNewIN{
	
	public SecurityCodeValidIN(){}
	
	public SecurityCodeValidIN(String rfc, String phoneNumber, String securityCode) {
		setPhoneNumber(phoneNumber);
		setRfc(rfc);
		this.securityCode=securityCode;
	}

	@NotNull(message="La clave es requerida")
	@Pattern(regexp="([0-9]{6})", message="La clave es incorrecta")
	private String securityCode;

	public String getSecurityCode() {
		return securityCode;
	}

	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}

}
