import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.mx.santander.lh.obpymes.servicios.Calculadora;

import junit.framework.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MockServletContext.class)
@WebAppConfiguration
public class CalculadoraTest {
	
	
	@Test
	public void testRecibe2ValoresMinimosSiNoExcepcion(){
		Calculadora calc=new Calculadora();
		List valores=new ArrayList();
		valores.add(1);
		
		
			try {
				calc.suma(valores);
				Assert.assertTrue(false);
			} catch (excepciones.ExcepcionValoresInvalidos e) {
				Assert.assertTrue(true);
			}
		
	}

}
