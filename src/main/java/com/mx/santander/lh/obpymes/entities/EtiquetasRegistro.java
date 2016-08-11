package com.mx.santander.lh.obpymes.entities;

import java.util.ArrayList;
import java.util.List;

public class EtiquetasRegistro {

	private List<Mensaje> mensajeRequisito = new ArrayList<Mensaje>();
	
	public EtiquetasRegistro() {
		Mensaje msg=new Mensaje(1L,"Ser <font color=red>residentes fiscales en M&eacute;xico.</font><br>Facturaci&oacute;n anual <font color=red>menor de 49.9 millones de pesos.</font>");
		mensajeRequisito.add(msg);
		// msg=new Mensaje(2L,"Facturación anual menor de 49.9 millones de pesos.");
		//mensajeRequisito.add(msg);
		msg=new Mensaje(3L,"Identificación oficial: IFE/INE o Pasaporte");
		mensajeRequisito.add(msg);
		msg=new Mensaje(4L,"Cedula completa del RFC");
		mensajeRequisito.add(msg);
		msg=new Mensaje(5L,"Comprobante del domicilio: recibo de luz, telefonía fija (telmex,izzi, axtel,total play), agua");
		mensajeRequisito.add(msg);
		
	}

	
	public List<Mensaje> getMensajeRequisito() {
		return mensajeRequisito;
	}


	public void setMensajeRequisito(List<Mensaje> mensajeRequisito) {
		this.mensajeRequisito = mensajeRequisito;
	}


	public Mensaje getMensajeRequisito(int id) {
		if(id>mensajeRequisito.size()||mensajeRequisito.get(id)==null){
			throw new IllegalArgumentException("Mensaje no existe");
		}
		return mensajeRequisito.get(id);
	}
	
	
	
	

	

}
