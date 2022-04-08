package com.the.simone.seor.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.the.simone.seor.model.request.CfRequest;


@Service
public class CalcoloCfService {
	
	RestTemplate restTemplate = new RestTemplate();
	
	public String calcoloCf(CfRequest request) {
		
		 String fooResourceUrl
			= "http://localhost:8082/nodb/calcolocf";
			 String  response
			= restTemplate.postForObject(fooResourceUrl , request, String.class);

			return response;
	}
	

}
