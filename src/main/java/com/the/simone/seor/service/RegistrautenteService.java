package com.the.simone.seor.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.the.simone.seor.model.request.RegistraUtenteStep1Request;
import com.the.simone.seor.model.response.InserisciUtenteResponse;

@Service
public class RegistrautenteService {
	
	RestTemplate restTemplate = new RestTemplate();

	public InserisciUtenteResponse inseriSciUtente(RegistraUtenteStep1Request request ) {

		InserisciUtenteResponse response = new InserisciUtenteResponse();
		
		//controllo username
		String responseusername = controllaUsername(request);
		if(responseusername.equals("OK username libero")) {
			
			String fooResourceUrl
			= "http://localhost:8083/utente/inserisci";
			response.setRespon(
			 restTemplate.postForObject(fooResourceUrl, request, String.class));
			
			response.setUsername(request.getUsername());
			
		}else {
			response.setRespon(  "username gia in uso");
			response.setUsername(request.getUsername());
		}

		return response;
	}
	
	public String controllaUsername (RegistraUtenteStep1Request request) {
		
		String fooResourceUrl
		= "http://localhost:8083/utente/controlla/username";
		String  response
		= restTemplate.postForObject(fooResourceUrl, request.getUsername(), String.class);

		return response;
	}
	
	

}
