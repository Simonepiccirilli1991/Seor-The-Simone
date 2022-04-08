package com.the.simone.seor.service;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import com.the.simone.seor.model.request.GoogleCaptchaRequest;
import com.the.simone.seor.model.response.GoogleCaptchaResponse;

public class GoogleCaptchaService {
	
	RestTemplate restT = new RestTemplate();
	
	public GoogleCaptchaResponse checkCaptcha(@RequestBody GoogleCaptchaRequest request) {
		
		GoogleCaptchaResponse response = new GoogleCaptchaResponse();
		
		String uri = "http://localhost:8084/nodb/v1/google/cap";
		
		try {
		response = restT.postForObject(uri, request, GoogleCaptchaResponse.class);
		
		}catch(Exception e) {
			
		}
		if(response.isSuccess()== false && response.getErrId().contentEquals("2"))
			response.setErrDesc("Si prega di riprovare piu tardi");
		
		return response;
	}

}
