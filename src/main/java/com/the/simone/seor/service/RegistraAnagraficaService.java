package com.the.simone.seor.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.the.simone.seor.model.request.RegistraUtenteStep2Request;


@Service
public class RegistraAnagraficaService {
	
	RestTemplate restTemplate = new RestTemplate();

	public String inserisciAnagrafica(RegistraUtenteStep2Request request ) {


		String fooResourceUrl
		= "http://localhost:8083/anagrafica/v1/post/inserisci/anagraficaS";
		
		String response = restTemplate.postForObject(fooResourceUrl, request, String.class);
		
		return response;
	}

}
