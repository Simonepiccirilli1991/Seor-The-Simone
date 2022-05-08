package com.the.simone.seor.fragment;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.the.simone.seor.model.request.CheckOtpRequest;
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
	
	public String checkOtp(CheckOtpRequest request) {
		
		String fooResourceUrl
		= "http://localhost:8079/cache/otp/check";
		String  response
		= restTemplate.postForObject(fooResourceUrl , request, String.class);
		 
		 return response;
	}
	
	public String cancellaCache(long transactionId) {
		String fooResourceUrl
		= "http://localhost:8079/cache/otp/cancella";
		String  response
		= restTemplate.postForObject(fooResourceUrl , transactionId, String.class);
		 
		 return response;
	}
	
	
}
