package com.mx.santander.lh.obpymes.servicios;

import org.springframework.stereotype.Service;

@Service
public class ServicioListaNegraImpl implements ServicioListaNegra{

	//@Override
	public boolean validaListaNegra(String rfc) {
		if(rfc.equalsIgnoreCase("OOPA820911IA7")){
			return true;
		}
		else{
			return false;
		}
		
	}

}
