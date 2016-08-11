package com.mx.santander.lh.obpymes.entities;

public class Mensaje {

	private Long id;
	private String contenido;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public Mensaje() {
		// TODO Auto-generated constructor stub
	}
	
	public Mensaje(Long id, String contenido) {
		this.id=id;
		this.contenido=contenido;
		// TODO Auto-generated constructor stub
	}

	


}
