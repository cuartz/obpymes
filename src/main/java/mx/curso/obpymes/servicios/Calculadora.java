package mx.curso.obpymes.servicios;

import java.util.List;

import excepciones.ExcepcionValoresInvalidos;

public class Calculadora {

	public void suma(List valores) throws  ExcepcionValoresInvalidos{
		if(valores.size()<2){
			throw new ExcepcionValoresInvalidos();
		}
		
		
	}

}
