package com.mx.santander.lh.obpymes.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.google.gson.Gson;
import com.mx.santander.lh.obpymes.excepciones.ObPymeServiceException;
import com.mx.santander.lh.obpymes.input.SecurityCodeNewIN;
import com.mx.santander.lh.obpymes.input.SecurityCodeValidIN;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MockServletContext.class)
@WebAppConfiguration

public class SecurityCodeControllerTest {

	private MockMvc mockMvc;

	@InjectMocks
	SecurityCodeController securityCodeController;
	
	@Before
	public void setUp() throws ObPymeServiceException{
		MockitoAnnotations.initMocks(this);
		mockMvc= MockMvcBuilders.standaloneSetup(securityCodeController).build();
	}
	
	@Test
	public void testValidPhoneNumberAndRFCMoral() throws Exception{
		Gson gson=new Gson();
		SecurityCodeNewIN securityCodeIN=new SecurityCodeNewIN("OOPA820911IA7","1234567890");
		
		MvcResult result = mockMvc.perform(post("/securityCode/new")
	            .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
	            .content(gson.toJson(securityCodeIN))
	    )
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.code",CoreMatchers.equalTo("200")))
				.andReturn();
		System.out.println(result.getResponse().getContentAsString());
	            ;
	}
	
	@Test
	public void testInvalidNullPhone() throws Exception{
		Gson gson=new Gson();
		SecurityCodeNewIN securityCodeIN=new SecurityCodeNewIN("OOPA820911IA7",null);
		
		MvcResult result = mockMvc.perform(post("/securityCode/new")
	            .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
	            .content(gson.toJson(securityCodeIN))
	    )
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.code",CoreMatchers.equalTo("2")))
				.andReturn();
		System.out.println(result.getResponse().getContentAsString());
	            ;
	}
	
	@Test
	public void testInvalidNullRFC() throws Exception{
		Gson gson=new Gson();
		SecurityCodeNewIN securityCodeIN=new SecurityCodeNewIN(null,"1234567890");
		
		MvcResult result = mockMvc.perform(post("/securityCode/new")
	            .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
	            .content(gson.toJson(securityCodeIN))
	    )
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.code",CoreMatchers.equalTo("2")))
				.andReturn();
		System.out.println(result.getResponse().getContentAsString());
	            ;
	}
	
	@Test
	public void testInvalidRFCLessThan12() throws Exception{
		Gson gson=new Gson();
		SecurityCodeNewIN securityCodeIN=new SecurityCodeNewIN("PA820911IA7","1234567890");
		
		MvcResult result = mockMvc.perform(post("/securityCode/new")
	            .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
	            .content(gson.toJson(securityCodeIN))
	    )
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.code",CoreMatchers.equalTo("2")))
				.andReturn();
		System.out.println(result.getResponse().getContentAsString());
	            ;
	}
	
	@Test
	public void testValidPhoneNumberAndRFCFisica() throws Exception{
		Gson gson=new Gson();
		SecurityCodeNewIN securityCodeIN=new SecurityCodeNewIN("OOPA820911IA7","1234567890");
		
		MvcResult result = mockMvc.perform(post("/securityCode/new")
	            .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
	            .content(gson.toJson(securityCodeIN))
	    )
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.code",CoreMatchers.equalTo("200")))
				.andReturn();
		System.out.println(result.getResponse().getContentAsString());
	            ;
	}
	
	@Test
	public void testInvalidRFCFormatNumberInsteadLetter() throws Exception{
		Gson gson=new Gson();
		SecurityCodeNewIN securityCodeIN=new SecurityCodeNewIN("O8PA820911IA7","1234567890");
		
		MvcResult result = mockMvc.perform(post("/securityCode/new")
	            .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
	            .content(gson.toJson(securityCodeIN))
	    )
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.code",CoreMatchers.equalTo("2")))
				.andReturn();
		System.out.println(result.getResponse().getContentAsString());
	            ;
	}
	
	@Test
	public void testInvalidRFCFormatLEtterInsteadNumber() throws Exception{
		Gson gson=new Gson();
		SecurityCodeNewIN securityCodeIN=new SecurityCodeNewIN("OOPA82O911IA7","1234567890");
		
		MvcResult result = mockMvc.perform(post("/securityCode/new")
	            .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
	            .content(gson.toJson(securityCodeIN))
	    )
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.code",CoreMatchers.equalTo("2")))
				.andReturn();
		System.out.println(result.getResponse().getContentAsString());
	            ;
	}
	
	@Test
	public void testInvalidPhoneNumberNotNumber() throws Exception{
		Gson gson=new Gson();
		SecurityCodeNewIN securityCodeIN=new SecurityCodeNewIN("OOPA820911IA7","aaaaaaaaa");
		
		MvcResult result = mockMvc.perform(post("/securityCode/new")
	            .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
	            .content(gson.toJson(securityCodeIN)))
	   
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.code",CoreMatchers.equalTo("2")))
				.andReturn();
		System.out.println(result.getResponse().getContentAsString());
	            ;
	}
	
	@Test
	public void testInvalidPhoneNumberMoreThan10Digits() throws Exception{
		Gson gson=new Gson();
		SecurityCodeNewIN securityCodeIN=new SecurityCodeNewIN("OOPA820911IA7","12345678901");
		
		MvcResult result = mockMvc.perform(post("/securityCode/new")
	            .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
	            .content(gson.toJson(securityCodeIN))
	    )
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.code",CoreMatchers.equalTo("2")))
				.andReturn();
		System.out.println(result.getResponse().getContentAsString());
	            ;
	}
	
	@Test
	public void testInvalidPhoneNumberLessThan10() throws Exception{
		Gson gson=new Gson();
		SecurityCodeNewIN securityCodeIN=new SecurityCodeNewIN("OOPA820911IA7","123456789");
		
		MvcResult result = mockMvc.perform(post("/securityCode/new")
	            .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
	            .content(gson.toJson(securityCodeIN))
	    )
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.code",CoreMatchers.equalTo("2")))
				.andReturn();
		System.out.println(result.getResponse().getContentAsString());
	            ;
	}
	
	@Test
	public void testInvalidPhoneNumberInvalidCharacters() throws Exception{
		Gson gson=new Gson();
		SecurityCodeNewIN securityCodeIN=new SecurityCodeNewIN("OOPA820911IA7","123#56789");
		
		MvcResult result = mockMvc.perform(post("/securityCode/new")
	            .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
	            .content(gson.toJson(securityCodeIN))
	    )
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.code",CoreMatchers.equalTo("2")))
				.andReturn();
		System.out.println(result.getResponse().getContentAsString());
	            ;
	}
	
	@Test
	public void testInvalidSecurityCodeIsNull() throws Exception{
		Gson gson=new Gson();
		SecurityCodeValidIN securityCodeIN=new SecurityCodeValidIN("OOPA820911IA7","123#56789",null);
		
		MvcResult result = mockMvc.perform(post("/securityCode/valid")
	            .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
	            .content(gson.toJson(securityCodeIN))
	    )
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.code",CoreMatchers.equalTo("2")))
				.andReturn();
		System.out.println(result.getResponse().getContentAsString());
	            ;
	}
	
	@Test
	public void testInvalidSecurityCodeRFCIsNull() throws Exception{
		Gson gson=new Gson();
		SecurityCodeValidIN securityCodeIN=new SecurityCodeValidIN(null,"123#56789","123456");
		
		MvcResult result = mockMvc.perform(post("/securityCode/valid")
	            .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
	            .content(gson.toJson(securityCodeIN))
	    )
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.code",CoreMatchers.equalTo("2")))
				.andReturn();
		System.out.println(result.getResponse().getContentAsString());
	            ;
	}
	
	@Test
	public void testInvalidSecurityCodePhoneNumberIsNull() throws Exception{
		Gson gson=new Gson();
		SecurityCodeValidIN securityCodeIN=new SecurityCodeValidIN("OOPA820911IA7",null,"123456");
		
		MvcResult result = mockMvc.perform(post("/securityCode/valid")
	            .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
	            .content(gson.toJson(securityCodeIN))
	    )
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.code",CoreMatchers.equalTo("2")))
				.andReturn();
		System.out.println(result.getResponse().getContentAsString());
	            ;
	}
	
	@Test
	public void testInvalidSecurityCodeHaveLetter() throws Exception{
		Gson gson=new Gson();
		SecurityCodeValidIN securityCodeIN=new SecurityCodeValidIN("OOPA820911IA7","1234567890","1w3456");
		
		MvcResult result = mockMvc.perform(post("/securityCode/valid")
	            .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
	            .content(gson.toJson(securityCodeIN))
	    )
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.code",CoreMatchers.equalTo("2")))
				.andReturn();
		System.out.println(result.getResponse().getContentAsString());
	            ;
	}
	
	@Test
	public void testInvalidSecurityCodeHaveSpecialCharacters() throws Exception{
		Gson gson=new Gson();
		SecurityCodeValidIN securityCodeIN=new SecurityCodeValidIN("OOPA820911IA7","1234567890","123<56");
		
		MvcResult result = mockMvc.perform(post("/securityCode/valid")
	            .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
	            .content(gson.toJson(securityCodeIN))
	    )
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.code",CoreMatchers.equalTo("2")))
				.andReturn();
		System.out.println(result.getResponse().getContentAsString());
	            ;
	}
	
	@Test
	public void testInvalidSecurityCodeLessThan6() throws Exception{
		Gson gson=new Gson();
		SecurityCodeValidIN securityCodeIN=new SecurityCodeValidIN("OOPA820911IA7","1234567890","12356");
		
		MvcResult result = mockMvc.perform(post("/securityCode/valid")
	            .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
	            .content(gson.toJson(securityCodeIN))
	    )
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.code",CoreMatchers.equalTo("2")))
				.andReturn();
		System.out.println(result.getResponse().getContentAsString());
	            ;
	}
	
	@Test
	public void testInvalidSecurityCodeMoreThan6() throws Exception{
		Gson gson=new Gson();
		SecurityCodeValidIN securityCodeIN=new SecurityCodeValidIN("OOPA820911IA7","1234567890","1235676");
		
		MvcResult result = mockMvc.perform(post("/securityCode/valid")
	            .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
	            .content(gson.toJson(securityCodeIN))
	    )
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.code",CoreMatchers.equalTo("2")))
				.andReturn();
		System.out.println(result.getResponse().getContentAsString());
	            ;
	}
	
	@Test
	public void testValidSecurityCode() throws Exception{
		Gson gson=new Gson();
		SecurityCodeValidIN securityCodeIN=new SecurityCodeValidIN("OOPA820911IA7","1234567890","123456");
		
		MvcResult result = mockMvc.perform(post("/securityCode/valid")
	            .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
	            .content(gson.toJson(securityCodeIN))
	    )
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.code",CoreMatchers.equalTo("200")))
				.andReturn();
		System.out.println(result.getResponse().getContentAsString());
	            ;
	}
	
}
