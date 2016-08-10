package mx.curso.obpymes.controllers;

import java.util.List;

import mx.curso.obpymes.entities.EtiquetasRegistro;
import mx.curso.obpymes.entities.Mensaje;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MensajesController {

	public MensajesController() {
		// TODO Auto-generated constructor stub
	}

	@CrossOrigin
	@RequestMapping("/mensajes")
	public Mensaje getMensaje(@RequestParam(value="id",defaultValue="0") int id){
		
		try{
		return new EtiquetasRegistro().getMensajeRequisito(id);
		}
		catch(IllegalArgumentException ia){
			return new Mensaje(999l,"Id no valido");
		}
	}
	
	@RequestMapping("/mensajes/todo")
	public List<Mensaje> getMensajes(){
		
		return new EtiquetasRegistro().getMensajeRequisito();
		
	}


}
