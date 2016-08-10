package mx.curso.obpymes.validation;

import mx.curso.obpymes.entities.Cliente;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;





public class ClienteValidator implements Validator{

	public boolean supports(Class clazz) {
		return Cliente.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {
		Cliente cliente=(Cliente)target;
		if(validaValueNotNull(cliente.getRfc(),errors,"rfc","RFC")){
			
			if(cliente.getRfc().length()==12){
				validaFormatoRFCMoral(cliente.getRfc(), errors);
			}
			else if(cliente.getRfc().length()==13){
				validaFormatoRFCFisica(cliente.getRfc(), errors);
			}
			else{
				errors.rejectValue("rfc","Longitud de RFC incorrecta");
			}
		}
		
		
		if(cliente.getRfc()!=null){
			if(validaValueNotNull(cliente.getNombre(),errors,"nombre","Nombre")){
				validaExpresion("nombre", "nombre", cliente.getNombre(), "[A-Z]{3,20}", errors);
			}
			if(validaValueNotNull(cliente.getApPaterno(),errors,"apPaterno","Apellido paterno")){
				validaExpresion("apPaterno", "apellido paterno", cliente.getApPaterno(), "[A-Z]{3,20}", errors);
			}
			if(validaValueNotNull(cliente.getApMaterno(),errors,"apMaterno","Apellido materno")){
				validaExpresion("apMaterno", "apellido materno", cliente.getApMaterno(), "[A-Z]{3,20}", errors);
			}
			if(validaValueNotNull(cliente.getEmail(),errors,"email","Correo electrónico")){
				validaEmail(cliente, errors);
			}
			if(validaValueNotNull(cliente.getCodigoPostal(),errors,"codigoPostal","Código postal")){
				validaExpresion("codigoPostal", "Código postal", cliente.getCodigoPostal(), "[0-9]{5}", errors);
			}
			
			/*if(validaValueNotNull(cliente.getNumeroTelefonico(),errors,"numeroTelefonico","numero telefónico")){
				validaExpresion("numeroTelefonico", "numero telefónico", cliente.getNumeroTelefonico(), "[0-9]{10}", errors);
			}*/
			
		}
		
	}
	
	

	private boolean validaValueNotNull(Object campoValor,Errors errors, String nombreCampo,String descCampo){
		if(campoValor==null){
			errors.rejectValue(nombreCampo, descCampo+" no puede estar vacio");
			return false;
		}
		else{
			return true;
		}
		
	}
	
	private boolean validaFormatoRFCMoral(String rfc, Errors errors){
		if(rfc.toUpperCase().matches("[A-Z]{3}[0-9]{6}[A-Z0-9]{3}")){
			return true;
		}
		else{
			errors.rejectValue("rfc","RFC persona moral incorrecto");
			return false;
		}
	}
	
	private boolean validaExpresion(String campo,String descCampo,String value,String exp,Errors errors){
		if(value.toUpperCase().matches(exp)){
			return true;
		}
		else{
			errors.rejectValue(campo,"El "+descCampo+" no es correcto");
			return false;
		}
	}
	
	private boolean validaFormatoRFCFisica(String rfc, Errors errors){
		if(rfc.toUpperCase().matches("[A-Z]{4}[0-9]{6}[A-Z0-9]{3}")){
			return true;
		}
		else{
			errors.rejectValue("rfc","RFC persona fisica incorrecto");
			return false;
		}
	}
	
	public boolean validaEmail(Cliente cliente,Errors errors){
		if(!cliente.getEmail().matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")){
            errors.rejectValue("email", "Formato de correo incorrecto");
            return false;
        }
		return true;
	}
	
	

	

}
