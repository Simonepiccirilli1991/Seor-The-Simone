package com.the.simone.seor.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;



@Service
public class MorraService {
	
	RestTemplate restTemplate = new RestTemplate();

	public String morraService(String val1, String val2 ) {

		String fooResourceUrl
		= "http://localhost:8082/nodb/mora/"+val1+"/"+val2;
		String  response
		= restTemplate.getForObject(fooResourceUrl, String.class, String.class);

		return response;
	}

}
