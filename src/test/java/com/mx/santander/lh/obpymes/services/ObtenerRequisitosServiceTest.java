package com.mx.santander.lh.obpymes.services;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.github.fakemongo.Fongo;
import com.mongodb.Mongo;
import com.mx.santander.lh.obpymes.ObpymesApplication;
import com.mx.santander.lh.obpymes.entities.Conditions;
import com.mx.santander.lh.obpymes.entities.ConfigurableParameters;
import com.mx.santander.lh.obpymes.entities.Documents;
import com.mx.santander.lh.obpymes.entities.Requirements;
import com.mx.santander.lh.obpymes.excepciones.ObPymeServiceException;
import com.mx.santander.lh.obpymes.repository.ConditionsRepository;
import com.mx.santander.lh.obpymes.repository.ConfigurableParametersRepository;
import com.mx.santander.lh.obpymes.repository.RequiredDocumentsRepository;
import com.mx.santander.lh.obpymes.services.ObtenRequisitosService;




@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ObpymesApplication.class)
//@ContextConfiguration
//@WebAppConfiguration

public class ObtenerRequisitosServiceTest {
	
	@Autowired
	ConditionsRepository conditionsRepository;
	
	@Autowired
	ConfigurableParametersRepository configurableParametersRepository;
	
	@Autowired
	RequiredDocumentsRepository requiredDocumentsRepository;
	
	@Autowired
	ObtenRequisitosService obtenRequisitosService;
	
	
	
	 @Configuration
		@EnableMongoRepositories
		//@ComponentScan( { "com.mx.santander.lh.obpymes;com.mx.santander.lh.obpymes.config;" })
		static class MongoConfiguration extends AbstractMongoConfiguration {

			@Override
			protected String getDatabaseName() {
				return "obpyme";
			}

			@Override
			public Mongo mongo() {
				return new Fongo("obpyme").getMongo();
			}

			@Override
			protected String getMappingBasePackage() {
				return "com.mx.santander.lh.obpymes.repository";
			}
		}
	
	@Test
	public void testGetPymeRequirementsMessages() throws ObPymeServiceException{
		conditionsRepository.save(new Conditions("1","Ser <font color=red>residentes fiscales en M&eacute;xico.</font>"));
		conditionsRepository.save( new Conditions("2","Facturaci&oacute;n anual <font color=red>menor de 49.9 millones de pesos.</font>"));
		requiredDocumentsRepository.save(new Documents("1","<b>Identificaci&oacute;n oficial</b>: IFE/INE o Pasaporte Mexicano, Residencia permanente, recuerda que no debe superar el tama&ntilde;o m&aacute;ximo de 1 MB"));
		requiredDocumentsRepository.save(new Documents("2","<b>Comprobante fiscal</b>, recuerda que no debe superar el tama&ntilde;o m&aacute;ximo de 1 MB"));
		requiredDocumentsRepository.save(new Documents("3","<b>Comprobante de domicilio</b>, no puede tener una antig&uuml;edad de m&aacute;s de 3  meses, recuerda que no debe superar el tama&ntilde;o m&aacute;ximo de 1 MB.<br><ul><li>Recibo de luz</li><li>Recibo de agua</li><li>Recibo de telefon&iacute;a fija (telmex, izzy, axtel, total play).</li><li>Estado de cuenta bancario (Santander, Bancomer, HSBC, Banregio,Scotiabank, Banorte, Banamex)</li></ul>"));
		configurableParametersRepository.save(new ConfigurableParameters("1","DaysToInactive","7"));
  
        Requirements requisitos=obtenRequisitosService.getRequisitos();
        assertEquals(2,requisitos.getConditions().size());
        assertEquals(3,requisitos.getDocuments().size());
        
        assertEquals("7",requisitos.getDays());
        Conditions condition=requisitos.getConditions().get(0);
        assertEquals("Ser <font color=red>residentes fiscales en M&eacute;xico.</font>",condition.getContent());
		
	}
	
	

}
