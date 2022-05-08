package com.the.simone.seor.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.the.simone.seor.model.Sicurezza;
import com.the.simone.seor.model.request.EnforcementRequest;


@Service
public class EnforceService {

	RestTemplate restTemplate = new RestTemplate();

	public String enforce(Sicurezza request ,String username) {

		EnforcementRequest iRequest = new EnforcementRequest();
		iRequest.setUsername(username);
		iRequest.setSicurezza(request);
		String fooResourceUrl
		= "http://localhost:8083/sicurezza/v1/sic/inserisci/";
		
		String response = restTemplate.postForObject(fooResourceUrl, iRequest, String.class);
		
		if(!response.equals("OK"))
			response = "KO";
		else 
			response ="OK";
		
		return response;
	}
}
