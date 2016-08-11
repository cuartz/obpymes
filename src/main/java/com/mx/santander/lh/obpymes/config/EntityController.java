package com.mx.santander.lh.obpymes.config;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class EntityController {

	@Autowired
	private SocketService socketService;
	@CrossOrigin
	@RequestMapping(value="/modifyEntity", method=RequestMethod.POST,produces=MediaType.TEXT_PLAIN_VALUE)
	public void modifyEntity(@RequestBody String requestString, HttpServletRequest request){
		ObjectMapper mapper= new ObjectMapper();
		try {
			JsonNode actualObj=mapper.readTree(requestString).path("entity");
			socketService.notifyChange(mapper.readValue(mapper.readTree(requestString).path("variableName").traverse(), java.lang.String.class), mapper.readValue(actualObj.traverse(), java.lang.Object.class));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("entro");
	}
}
