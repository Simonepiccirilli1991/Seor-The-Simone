package com.the.simone.seor.fragment;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.the.simone.seor.model.request.OtpMailRequest;
import com.the.simone.seor.model.response.CacheResponse;
import com.the.simone.seor.model.response.SendOtpResponse;

@Service
public class CacheService {

	
	RestTemplate restTemplate = new RestTemplate();
	
	public SendOtpResponse inserisciCache(OtpMailRequest request) {
		
		String fooResourceUrl
		= "http://localhost:8079/cache/otp/in";
		SendOtpResponse  response
		= restTemplate.postForObject(fooResourceUrl , request, SendOtpResponse.class);
		 
		 return response;
	}
	
	
}
