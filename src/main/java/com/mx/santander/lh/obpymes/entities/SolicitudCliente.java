package com.mx.santander.lh.obpymes.entities;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class SolicitudCliente {
	
	@NotEmpty(message="RFC no puede estar vacio")
	private String rfc;
	
	private String nombre;
	private String apPaterno;
	private String apMaterno;
	private String email;
	private String codigoPostal;
	
	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApPaterno() {
		return apPaterno;
	}

	public void setApPaterno(String apPaterno) {
		this.apPaterno = apPaterno;
	}

	public String getApMaterno() {
		return apMaterno;
	}

	public void setApMaterno(String apMaterno) {
		this.apMaterno = apMaterno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getRfc() {
		return rfc;
	}

	public SolicitudCliente() {
		// TODO Auto-generated constructor stub
	}

	public void setRfc(String rfc) {
		this.rfc=rfc;
		
	}

	

}
