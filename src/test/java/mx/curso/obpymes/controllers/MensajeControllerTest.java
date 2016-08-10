package mx.curso.obpymes.controllers;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.hamcrest.Matchers.*;



@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MockServletContext.class)
@WebAppConfiguration
public class MensajeControllerTest {

	
	private MockMvc mvc;
	
	@Before
	public void setUp(){
		mvc= MockMvcBuilders.standaloneSetup(new MensajesController()).build();
	}
	
	@Test
	public void testMensajeController() throws Exception{
		mvc.perform(MockMvcRequestBuilders.get("/mensajes?id=0").accept(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("contenido",CoreMatchers.equalTo("Ser <font color=red>residentes fiscales en M&eacute;xico.</font><br>Facturaci&oacute;n anual <font color=red>menor de 49.9 millones de pesos.</font>")));
	}
	
	@Test
	public void testMensajeNoEncontrado() throws Exception{
		mvc.perform(MockMvcRequestBuilders.get("/mensajes?id=999").accept(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("contenido",CoreMatchers.equalTo("Id no valido")));
	}
	
	@Test
	public void testTodosMensajes() throws Exception{
		
		mvc.perform(MockMvcRequestBuilders.get("/mensajes/todo").accept(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(4)));
	}

}
