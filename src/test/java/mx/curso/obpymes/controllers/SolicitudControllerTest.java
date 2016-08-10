package mx.curso.obpymes.controllers;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.google.gson.Gson;


import mx.curso.obpymes.entities.Cliente;
import mx.curso.obpymes.servicios.ServicioListaNegra;
import mx.curso.obpymes.servicios.ServicioNoCliente;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MockServletContext.class)
@WebAppConfiguration
public class SolicitudControllerTest {

private MockMvc mockMvc;

@Mock
ServicioListaNegra servicioListaNegra;

@Mock
ServicioNoCliente servicioNoCliente;


@InjectMocks
SolicitudController solicitudController;





	
	@Before
	public void setUp(){
		MockitoAnnotations.initMocks(this);
		mockMvc= MockMvcBuilders.standaloneSetup(solicitudController).build();
		when(servicioListaNegra.validaListaNegra("OOPA820911IA7")).thenReturn(true);
		when(servicioListaNegra.validaListaNegra("AAPA820911IA7")).thenReturn(false);
		when(servicioNoCliente.validaNoCliente("AAPA820911IA7")).thenReturn(false);
	}
	
	@Test
	public void testValidaValidatorTodoOk() throws Exception{
	Cliente cliente=new Cliente();
	cliente.setRfc("OOPA820911IA7");
	cliente.setNombre("Aldo");
	cliente.setApPaterno("Orozco");
	cliente.setApMaterno("Pérez");
	cliente.setCodigoPostal("04250");
	cliente.setEmail("aorozco@gmail.com");
	Gson gson=new Gson();
	
	
	ResultActions resultActions=mockMvc.perform(post("/solicitud/nueva")
            .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
            .content(gson.toJson(cliente))
    ).andExpect(MockMvcResultMatchers.status().isBadRequest())
           
            ;
	
	resultActions.andDo(MockMvcResultHandlers.print());
	
	}
	
	@Test
	public void testValidaValidator() throws Exception{
	Cliente cliente=new Cliente();
	cliente.setRfc("OOPA820911IA7");
	cliente.setNombre("Aldo");
	cliente.setApMaterno("materno");
	cliente.setApPaterno("paterno");
	cliente.setEmail("mail");
	Gson gson=new Gson();
	
	
	ResultActions resultActions=mockMvc.perform(post("/solicitud/nueva")
            .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
            .content(gson.toJson(cliente))
    ).andExpect(MockMvcResultMatchers.status().isBadRequest())
           
            ;
	
	resultActions.andDo(MockMvcResultHandlers.print());
	
	}
	
	@Test
	public void testValidaLlamadoListaNegraEnListaNegra() throws Exception{
	Cliente cliente=new Cliente();
	cliente.setRfc("OOPA820911IA7");
	cliente.setNombre("Aldo");
	cliente.setApMaterno("materno");
	cliente.setApPaterno("paterno");
	cliente.setEmail("aldo.orozc@gmail.com");
	cliente.setCodigoPostal("04250");
	cliente.setNumeroTelefonico("1122112233");
	Gson gson=new Gson();
	
	
	ResultActions resultActions=mockMvc.perform(post("/solicitud/nueva")
            .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
            .content(gson.toJson(cliente))
    ).andExpect(MockMvcResultMatchers.status().isOk()).
			andExpect(MockMvcResultMatchers.jsonPath("$",CoreMatchers.equalTo(true)))
           
            ;
	
	verify(servicioListaNegra,times(1)).validaListaNegra("OOPA820911IA7");
	
	}
	
	@Test
	public void testValidaLlamadoListaNegraNoEnListaNegra() throws Exception{
	Cliente cliente=new Cliente();
	cliente.setRfc("AAPA820911IA7");
	cliente.setNombre("Aldo");
	cliente.setApMaterno("materno");
	cliente.setApPaterno("paterno");
	cliente.setEmail("aldo.orozc@gmail.com");
	cliente.setCodigoPostal("04250");
	cliente.setNumeroTelefonico("1122112233");
	Gson gson=new Gson();
	
	
	mockMvc.perform(post("/solicitud/nueva")
            .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
            .content(gson.toJson(cliente))
    ).andExpect(MockMvcResultMatchers.status().isOk()).
			andExpect(MockMvcResultMatchers.jsonPath("$",CoreMatchers.equalTo(false)))
           
            ;
	
	verify(servicioListaNegra,times(1)).validaListaNegra("AAPA820911IA7");
	
	}
	
	@Test
	public void testValidaLlamadoNoClienteVerdadero() throws Exception{
	Cliente cliente=new Cliente();
	cliente.setRfc("AAPA820911IA7");
	cliente.setNombre("Aldo");
	cliente.setApMaterno("materno");
	cliente.setApPaterno("paterno");
	cliente.setEmail("aldo.orozc@gmail.com");
	cliente.setCodigoPostal("04250");
	cliente.setNumeroTelefonico("5511223344");
	Gson gson=new Gson();
	
	
	mockMvc.perform(post("/solicitud/nueva")
            .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
            .content(gson.toJson(cliente))
    ).andExpect(MockMvcResultMatchers.status().isOk()).
			andExpect(MockMvcResultMatchers.jsonPath("$",CoreMatchers.equalTo(false)))
           
            ;
	
	
	
	verify(servicioNoCliente,times(1)).validaNoCliente("AAPA820911IA7");
	
	}
	
//	@Test
//	public void testValidaMensajeUnificado() throws Exception{
//	Cliente cliente=new Cliente();
//	cliente.setRfc("AAPA820911IA7");
//	cliente.setNombre("Ald0");
//	cliente.setApMaterno("materno");
//	cliente.setApPaterno("paterno");
//	cliente.setEmail("aldo.orozc@gmail.com");
//	cliente.setCodigoPostal("042500");
//	cliente.setNumeroTelefonico("5511223344");
//	Gson gson=new Gson();
//	
//	
//	mockMvc.perform(post("/solicitud/nueva")
//            .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
//            .content(gson.toJson(cliente))
//    ).andExpect(MockMvcResultMatchers.status().isBadRequest()).
//			andExpect(MockMvcResultMatchers.jsonPath("$",CoreMatchers.equalTo("El nombre no es correcto,El Código postal no es correcto")))
//           
//            ;
//	
//	
//	
//	
//	
//	}
	
}
