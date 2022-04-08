package com.the.simone.seor.fragment;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.the.simone.seor.model.request.OtpMailRequest;

@Service
public class SendMailService {
	
	RestTemplate restTemplate = new RestTemplate();
	
	public String invioOtsMail(OtpMailRequest request) {
		
		String fooResourceUrl
		= "http://localhost:8081/nodb/mail";
		 String  response
		= restTemplate.postForObject(fooResourceUrl , request, String.class);
		 
		 return response;
	}

}
