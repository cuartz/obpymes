package com.mx.santander.lh.obpymes.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.mx.santander.lh.obpymes.entities.Conditions;
import com.mx.santander.lh.obpymes.entities.ConfigurableParameters;
import com.mx.santander.lh.obpymes.entities.Documents;
import com.mx.santander.lh.obpymes.repository.ConditionsRepository;
import com.mx.santander.lh.obpymes.repository.ConfigurableParametersRepository;
import com.mx.santander.lh.obpymes.repository.RequiredDocumentsRepository;

@RestController
@RequestMapping(value = "/catalog")
public class CatalogController {
	
	@Autowired
	ConditionsRepository conditionsRepository;
	
	@Autowired
	ConfigurableParametersRepository configurableParametersRepository;
	
	@Autowired
	RequiredDocumentsRepository requiredDocumentsRepository;
	
	@CrossOrigin
	@RequestMapping(value="/documents", method = RequestMethod.GET)
	public ResponseEntity<Object> loadDocuments(){
		conditionsRepository.save(new Conditions("1","Ser <font color=red>residentes fiscales en M&eacute;xico.</font>"));
		conditionsRepository.save( new Conditions("2","Facturaci&oacute;n anual <font color=red>menor de 49.9 millones de pesos.</font>"));
		requiredDocumentsRepository.save(new Documents("1","<b>Identificaci&oacute;n oficial</b>: IFE/INE o Pasaporte Mexicano, Residencia permanente, recuerda que no debe superar el tama&ntilde;o m&aacute;ximo de 1 MB"));
		requiredDocumentsRepository.save(new Documents("2","<b>Comprobante fiscal</b>, recuerda que no debe superar el tama&ntilde;o m&aacute;ximo de 1 MB"));
		requiredDocumentsRepository.save(new Documents("3","<b>Comprobante de domicilio</b>, no puede tener una antig&uuml;edad de m&aacute;s de 3  meses, recuerda que no debe superar el tama&ntilde;o m&aacute;ximo de 1 MB.<br><ul><li>Recibo de luz</li><li>Recibo de agua</li><li>Recibo de telefon&iacute;a fija (telmex, izzy, axtel, total play).</li><li>Estado de cuenta bancario (Santander, Bancomer, HSBC, Banregio,Scotiabank, Banorte, Banamex)</li></ul>"));
		configurableParametersRepository.save(new ConfigurableParameters("1","DaysToInactive","7"));
		
		return ResponseEntity.status(HttpStatus.OK).body(new Gson().toJson(""));
	
	}

}
