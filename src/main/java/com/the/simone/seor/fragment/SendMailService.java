package com.the.simone.seor.fragment;

import java.time.Duration;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.the.simone.seor.model.request.OtpMailRequest;

@Service
public class SendMailService {
	
	RestTemplate restTemplate = new RestTemplate();
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder){
	        RestTemplate restTemplate= restTemplateBuilder.setConnectTimeout(Duration.ofMillis(20000)).setReadTimeout(Duration.ofMillis(20000)).build();
	        return restTemplate;

	}
	
	public String invioOtsMail(OtpMailRequest request) {
		
		
		String fooResourceUrl
		= "http://localhost:8081/nodb/mail";
		 String  response
		= restTemplate.postForObject(fooResourceUrl , request, String.class);
		 
		 return response;
	}

}
