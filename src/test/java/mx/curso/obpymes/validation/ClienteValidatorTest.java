package mx.curso.obpymes.validation;


import mx.curso.obpymes.entities.Cliente;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.util.Assert;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MockServletContext.class)
@WebAppConfiguration
public class ClienteValidatorTest {

	@Test
	public void testValidaRFCincorrecto() {

		Cliente cliente = new Cliente();
		BindingResult errors = new BeanPropertyBindingResult(cliente, "Cliente");

		ClienteValidator clienteValidator = new ClienteValidator();

		clienteValidator.validate(cliente, errors);

		Assert.isTrue(errors.getErrorCount() > 0);

	}

	@Test
	public void testValidaNoErrorRFCSiRFCpresente() {

		Cliente cliente = new Cliente();
		BindingResult errors = new BeanPropertyBindingResult(cliente, "Cliente");
		cliente.setRfc("PAA820911IA7");

		ClienteValidator clienteValidator = new ClienteValidator();

		clienteValidator.validate(cliente, errors);
		Assert.isTrue(errors.getFieldError("rfc") == null);

	}

	@Test
	public void testDatosNoCompletosConRFCPresente() {

		Cliente cliente = new Cliente();
		BindingResult errors = new BeanPropertyBindingResult(cliente, "Cliente");
		cliente.setRfc("OPA820911IA7");

		ClienteValidator clienteValidator = new ClienteValidator();

		clienteValidator.validate(cliente, errors);
		System.out.println(errors.toString());
		Assert.isTrue(errors.getErrorCount() == 5);

	}

	@Test
	public void testDatosCompletos() {

		Cliente cliente = new Cliente();
		BindingResult errors = new BeanPropertyBindingResult(cliente, "Cliente");
		cliente.setRfc("OOA820911IAI");
		cliente.setNombre("Aldo");
		cliente.setApPaterno("Orozco");
		cliente.setApMaterno("Perez");
		cliente.setCodigoPostal("04250");
		cliente.setEmail("aorozco@gmail.com");
		cliente.setNumeroTelefonico("5511223344");

		ClienteValidator clienteValidator = new ClienteValidator();

		clienteValidator.validate(cliente, errors);

		Assert.isTrue(errors.getErrorCount() == 0);

	}

	@Test
	public void testLongitudRFC() {
		Cliente cliente = new Cliente();
		BindingResult errors = new BeanPropertyBindingResult(cliente, "Cliente");
		cliente.setRfc("OOP820911I");

		ClienteValidator clienteValidator = new ClienteValidator();

		clienteValidator.validate(cliente, errors);

		Assert.isTrue(errors.getFieldError("rfc").getCode().equalsIgnoreCase("Longitud de RFC incorrecta"));

	}

	@Test
	public void testFormatoRFCMoralIncorrecto() {
		Cliente cliente = new Cliente();
		BindingResult errors = new BeanPropertyBindingResult(cliente, "Cliente");
		cliente.setRfc("OOPP820911II");

		ClienteValidator clienteValidator = new ClienteValidator();

		clienteValidator.validate(cliente, errors);

		Assert.isTrue(errors.getFieldError("rfc").getCode().equalsIgnoreCase("RFC persona moral incorrecto"));

	}

	@Test
	public void testFormatoRFCMoralCorrecto() {
		Cliente cliente = new Cliente();
		BindingResult errors = new BeanPropertyBindingResult(cliente, "Cliente");
		cliente.setRfc("OOP820911III");

		ClienteValidator clienteValidator = new ClienteValidator();

		clienteValidator.validate(cliente, errors);

		Assert.isTrue(errors.getFieldError("rfc") == null);

	}

	@Test
	public void testFormatoRFCFisicaCorrecto() {
		Cliente cliente = new Cliente();
		BindingResult errors = new BeanPropertyBindingResult(cliente, "Cliente");
		cliente.setRfc("OOPA820911III");

		ClienteValidator clienteValidator = new ClienteValidator();

		clienteValidator.validate(cliente, errors);
		System.out.println(errors.getFieldError("rfc"));
		Assert.isTrue(errors.getFieldError("rfc") == null);

	}

	@Test
	public void testFormatoRFCFisicaIncorrecto() {
		Cliente cliente = new Cliente();
		BindingResult errors = new BeanPropertyBindingResult(cliente, "Cliente");
		cliente.setRfc("OOPAA20911III");

		ClienteValidator clienteValidator = new ClienteValidator();

		clienteValidator.validate(cliente, errors);

		Assert.isTrue(errors.getFieldError("rfc").getCode().equalsIgnoreCase("RFC persona fisica incorrecto"));

	}

	@Test
	public void testNombreInvalido() {
		Cliente cliente = new Cliente();
		BindingResult errors = new BeanPropertyBindingResult(cliente, "Cliente");
		cliente.setRfc("OOA820911IAI");
		cliente.setNombre("Ald0");
		cliente.setApPaterno("Orozco");
		cliente.setApMaterno("Perez");
		cliente.setCodigoPostal("04250");
		cliente.setEmail("aorozco@gmail.com");

		ClienteValidator clienteValidator = new ClienteValidator();

		clienteValidator.validate(cliente, errors);

		Assert.isTrue(errors.getFieldError("nombre").getCode().equalsIgnoreCase("El nombre no es correcto"));
	}

	@Test
	public void testApPaternoInvalido() {
		Cliente cliente = new Cliente();
		BindingResult errors = new BeanPropertyBindingResult(cliente, "Cliente");
		cliente.setRfc("OOA820911IAI");
		cliente.setNombre("Aldo");
		cliente.setApPaterno("Oro2co");
		cliente.setApMaterno("Perez");
		cliente.setCodigoPostal("04250");
		cliente.setEmail("aorozco@gmail.com");

		ClienteValidator clienteValidator = new ClienteValidator();

		clienteValidator.validate(cliente, errors);

		Assert.isTrue(
				errors.getFieldError("apPaterno").getCode().equalsIgnoreCase("El apellido Paterno no es correcto"));
		cliente.setApPaterno("O");
		Assert.isTrue(
				errors.getFieldError("apPaterno").getCode().equalsIgnoreCase("El apellido Paterno no es correcto"));
	}

	@Test
	public void testApMaternoInvalido() {
		Cliente cliente = new Cliente();
		BindingResult errors = new BeanPropertyBindingResult(cliente, "Cliente");
		cliente.setRfc("OOA820911IAI");
		cliente.setNombre("Aldo");
		cliente.setApPaterno("Orozco");
		cliente.setApMaterno("Pe3rez");
		cliente.setCodigoPostal("04250");
		cliente.setEmail("aorozco@gmail.com");

		ClienteValidator clienteValidator = new ClienteValidator();

		clienteValidator.validate(cliente, errors);

		Assert.isTrue(
				errors.getFieldError("apMaterno").getCode().equalsIgnoreCase("El apellido materno no es correcto"));
	}

	@Test
	public void testEmailInvalido() {
		Cliente cliente = new Cliente();
		BindingResult errors = new BeanPropertyBindingResult(cliente, "Cliente");
		cliente.setRfc("OOA820911IAI");
		cliente.setNombre("Aldo");
		cliente.setApPaterno("Orozco");
		cliente.setApMaterno("Pérez");
		cliente.setCodigoPostal("04250");
		cliente.setEmail("aorozco@@gmail.com");

		ClienteValidator clienteValidator = new ClienteValidator();

		clienteValidator.validate(cliente, errors);

		Assert.isTrue(errors.getFieldError("email").getCode().equalsIgnoreCase("Formato de correo incorrecto"));
	}

	@Test
	public void testCodigoPostalInvalido() {
		Cliente cliente = new Cliente();
		BindingResult errors = new BeanPropertyBindingResult(cliente, "Cliente");
		cliente.setRfc("OOA820911IAI");
		cliente.setNombre("Aldo");
		cliente.setApPaterno("Orozco");
		cliente.setApMaterno("Pérez");
		cliente.setCodigoPostal("0A250");
		cliente.setEmail("aorozco@gmail.com");

		ClienteValidator clienteValidator = new ClienteValidator();

		clienteValidator.validate(cliente, errors);

		Assert.isTrue(errors.getFieldError("codigoPostal").getCode().equalsIgnoreCase("El Código postal no es correcto"));
		
		cliente.setCodigoPostal("1234");
		
		Assert.isTrue(errors.getFieldError("codigoPostal").getCode().equalsIgnoreCase("El Código postal no es correcto"));
		
	
	
	}
	
	
	public void testNumeroTelefonicoInvalido() {
		Cliente cliente = new Cliente();
		BindingResult errors = new BeanPropertyBindingResult(cliente, "Cliente");
		cliente.setRfc("OOA820911IAI");
		cliente.setNombre("Aldo");
		cliente.setApPaterno("Orozco");
		cliente.setApMaterno("Pérez");
		cliente.setCodigoPostal("04250");
		cliente.setEmail("aorozco@gmail.com");
		cliente.setNumeroTelefonico("a111234567");

		ClienteValidator clienteValidator = new ClienteValidator();

		clienteValidator.validate(cliente, errors);

		Assert.isTrue(errors.getFieldError("numeroTelefonico").getCode().equalsIgnoreCase("El numero telefónico no es correcto"));
		
		cliente.setCodigoPostal("11433322111");
		
		Assert.isTrue(errors.getFieldError("numeroTelefonico").getCode().equalsIgnoreCase("El numero telefónico no es correcto"));
		
	}

}
