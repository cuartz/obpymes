package com.mx.santander.lh.obpymes.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.mx.santander.lh.obpymes.entities.Cliente;
import com.mx.santander.lh.obpymes.entities.Mensaje;
import com.mx.santander.lh.obpymes.servicios.ServicioListaNegra;
import com.mx.santander.lh.obpymes.servicios.ServicioNoCliente;
import com.mx.santander.lh.obpymes.validation.ClienteValidator;

@RestController
@RequestMapping("/solicitud")
public class SolicitudController {
	
	@Autowired
	private ServicioListaNegra servicioListaNegra;
	
	@Autowired
	private ServicioNoCliente servicioNoCliente;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
	    binder.setValidator(new ClienteValidator());
	}
	
	@CrossOrigin
	@RequestMapping(value="/nueva", method = RequestMethod.POST)
	public ResponseEntity<String> validaDatos(@Valid @RequestBody Cliente cliente,BindingResult results){
		if(results.hasErrors()){
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Gson().toJson(new MensajeDeError(formatoMensajeError(results))));
		}
		else{
			boolean resultadoListaNegra= servicioListaNegra.validaListaNegra(cliente.getRfc());
			if(!resultadoListaNegra){
				 return ResponseEntity.ok(servicioNoCliente.validaNoCliente(cliente.getRfc())+"");
			}
			else{
				 return ResponseEntity.ok(resultadoListaNegra+"");
			}
			
		}
		
	}
	
	private String formatoMensajeError(BindingResult results){
		StringBuffer mensaje=new StringBuffer();
		for(ObjectError error:results.getAllErrors()){
			mensaje.append(error.getCode()+",");
			break;
		}
		return mensaje.toString().substring(0, mensaje.lastIndexOf(","));
	}
	
	class MensajeDeError{
		public String code="001";
		public String MensajeError;
		MensajeDeError(String MensajeError){
			this.MensajeError=MensajeError;
		}
	}
}


