package mx.curso.obpymes.servicios;

import org.springframework.stereotype.Service;

@Service
public class ServicioNoClienteImpl implements ServicioNoCliente{

	//@Override
	public boolean validaNoCliente(String rfc) {
		if(rfc.equalsIgnoreCase("AAPA820911IA7")){
			return true;
		}
		else{
			return false;
		}
	}

}
