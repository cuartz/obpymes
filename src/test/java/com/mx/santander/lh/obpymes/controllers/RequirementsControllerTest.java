package com.mx.santander.lh.obpymes.controllers;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.CoreMatchers;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.mx.santander.lh.obpymes.entities.Conditions;
import com.mx.santander.lh.obpymes.entities.ConfigurableParameters;
import com.mx.santander.lh.obpymes.entities.Documents;
import com.mx.santander.lh.obpymes.entities.Requirements;
import com.mx.santander.lh.obpymes.excepciones.ObPymeServiceException;
import com.mx.santander.lh.obpymes.services.ObtenRequisitosService;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MockServletContext.class)
@WebAppConfiguration
public class RequirementsControllerTest {
	
	private MockMvc mockMvc;

	@Mock
	ObtenRequisitosService obtenRequisitosService;

	
	@InjectMocks
	RequirementsController requirementsController;





		
		@Before
		public void setUp() throws ObPymeServiceException{
			MockitoAnnotations.initMocks(this);
			mockMvc= MockMvcBuilders.standaloneSetup(requirementsController).build();
			Requirements requirements=new Requirements();
			List<Conditions> conditions=new ArrayList<Conditions>();
			List<Documents> documents=new ArrayList<Documents>();
			List<ConfigurableParameters> configurableParameters=new ArrayList<ConfigurableParameters>();
			conditions.add(new Conditions("1","Ser <font color=red>residentes fiscales en M&eacute;xico.</font>"));
			conditions.add( new Conditions("2","Facturaci&oacute;n anual <font color=red>menor de 49.9 millones de pesos.</font>"));
			documents.add(new Documents("1","<b>Identificaci&oacute;n oficial</b>: IFE/INE o Pasaporte Mexicano, Residencia permanente, recuerda que no debe superar el tama&ntilde;o m&aacute;ximo de 1 MB"));
			documents.add(new Documents("2","<b>Comprobante fiscal</b>, recuerda que no debe superar el tama&ntilde;o m&aacute;ximo de 1 MB"));
			documents.add(new Documents("3","<b>Comprobante de domicilio</b>, no puede tener una antig&uuml;edad de m&aacute;s de 3  meses, recuerda que no debe superar el tama&ntilde;o m&aacute;ximo de 1 MB.<br><ul><li>Recibo de luz</li><li>Recibo de agua</li><li>Recibo de telefon&iacute;a fija (telmex, izzy, axtel, total play).</li><li>Estado de cuenta bancario (Santander, Bancomer, HSBC, Banregio,Scotiabank, Banorte, Banamex)</li></ul>"));
			configurableParameters.add(new ConfigurableParameters("1","DaysToInactive","7"));
			requirements.setDocuments(documents);
			requirements.setConditions(conditions);
			requirements.setDays("7");
			
			when(obtenRequisitosService.getRequirements()).thenReturn(requirements);
			when(obtenRequisitosService.getDocuments()).thenReturn(documents);
			when(obtenRequisitosService.getConditions()).thenReturn(conditions);
			when(obtenRequisitosService.getDays()).thenReturn("7");
			
		}
		
		
		@Test
		public void testGetRequirementsAll() throws Exception{
			MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/requirements/all").accept(MediaType.APPLICATION_JSON))
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.jsonPath("$.body.days",CoreMatchers.equalTo("7")))
			.andReturn();
			System.out.println(result.getResponse().getContentAsString());
			Mockito.reset(obtenRequisitosService);
			when(obtenRequisitosService.getRequirements()).thenThrow(ObPymeServiceException.class);
			result = mockMvc.perform(MockMvcRequestBuilders.get("/requirements/all").accept(MediaType.APPLICATION_JSON))
					.andExpect(MockMvcResultMatchers.status().isOk()).
					andExpect(MockMvcResultMatchers.jsonPath("$.message",CoreMatchers.equalTo("No se pudieron recuperar los requisitos")))
					.andExpect(MockMvcResultMatchers.jsonPath("$.code",CoreMatchers.equalTo("1")))
					.andReturn();
			System.out.println(result.getResponse().getContentAsString());
			
		}
		
		
		@Test
		public void testGetRequirementsDocuments() throws Exception{
			MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/requirements/documents").accept(MediaType.APPLICATION_JSON))
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.jsonPath("$.body",Matchers.hasSize(3)))
			//.andExpect(MockMvcResultMatchers.jsonPath("$.code",CoreMatchers.equalTo("200")))
			.andReturn();
			System.out.println(result.getResponse().getContentAsString());
			
			
		}
		
		@Test
		public void testGetRequirementsRequirements() throws Exception{
			MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/requirements/conditions").accept(MediaType.APPLICATION_JSON))
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.jsonPath("$.body",Matchers.hasSize(2))).
			andExpect(MockMvcResultMatchers.jsonPath("$.code",CoreMatchers.equalTo("200")))
			.andReturn();
			System.out.println(result.getResponse().getContentAsString());
			
			
		}
		
		@Test
		public void testGetRequirementsDays() throws Exception{
			MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/requirements/days").accept(MediaType.APPLICATION_JSON))
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.jsonPath("$.body",CoreMatchers.equalTo("7")))
			.andReturn();
			System.out.println(result.getResponse().getContentAsString());
			
			
		}
		
	
		
		

}
