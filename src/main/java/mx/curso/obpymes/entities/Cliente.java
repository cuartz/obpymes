package mx.curso.obpymes.entities;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;

public class Cliente {
	
	private String rfc;
	
	private String nombre;
	private String apPaterno;
	private String apMaterno;
	
	private String email;
	private String codigoPostal;
	
	private String numeroTelefonico;
	
	

	public String getNumeroTelefonico() {
		return numeroTelefonico;
	}

	public void setNumeroTelefonico(String numeroTelefonico) {
		this.numeroTelefonico = numeroTelefonico;
	}

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

	public Cliente() {
		// TODO Auto-generated constructor stub
	}

	public void setRfc(String rfc) {
		this.rfc=rfc;
		
	}

	

}
