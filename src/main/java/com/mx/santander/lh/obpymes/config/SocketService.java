package com.mx.santander.lh.obpymes.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.messaging.simp.SimpMessageSendingOperations;;

@Service
public class SocketService {

	@Autowired
	private SimpMessageSendingOperations messagingTemplate;
	
	public void notifyChange(String entityId, Object message){
		messagingTemplate.convertAndSend("/topic/entities/"+entityId,message);
	}
}
