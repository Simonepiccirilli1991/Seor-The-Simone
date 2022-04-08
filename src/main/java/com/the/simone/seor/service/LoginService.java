package com.the.simone.seor.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.the.simone.seor.model.request.LoginRequest;
import com.the.simone.seor.model.response.LoginResponse;

@Service
public class LoginService {
	
	RestTemplate restTemplate = new RestTemplate();
	
	public boolean checkPsw(LoginRequest request) {
		
		String fooResourceUrl
		= "http://localhost:8083/utente/v1/post/login";
		
		boolean response = restTemplate.postForObject(fooResourceUrl, request, boolean.class);
		
		return response;
		
	}
	
	public LoginResponse loginUtente(String username) {
		
		String fooResourceUrl
		= "http://localhost:8083/utente/trova/";
		
		LoginResponse response = restTemplate.getForObject(fooResourceUrl+username, LoginResponse.class);
		if(response.isError()) {
			//response.getErrId()
		}
		return response;
		
	}
	
	public LoginResponse infoUtente(String username) {
		
		String fooResourceUrl
		= "http://localhost:8083/utente/trova/";
		
		LoginResponse response = restTemplate.getForObject(fooResourceUrl+username, LoginResponse.class);
		if(response.isError()) {
			//response.getErrId()
		}
		return response;
		
	}

}
