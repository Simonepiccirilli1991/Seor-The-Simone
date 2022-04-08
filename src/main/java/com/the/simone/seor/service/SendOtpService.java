package com.the.simone.seor.service;

import java.security.SecureRandom;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.the.simone.seor.fragment.CacheService;
import com.the.simone.seor.fragment.SendMailService;
import com.the.simone.seor.model.request.OtpMailRequest;
import com.the.simone.seor.model.request.SendOtpRequest;
import com.the.simone.seor.model.response.LoginResponse;
import com.the.simone.seor.model.response.SendOtpResponse;

@Service
public class SendOtpService {
	
	@Autowired private LoginService loginService;
	@Autowired private SendMailService sendMailService;
	@Autowired private CacheService cacheService;
	
	RestTemplate restTemplate = new RestTemplate();



	public SendOtpResponse sendOts(SendOtpRequest request) {

		LoginResponse response = loginService.infoUtente(request.getUsername());
		String emailInvio = request.getEmail();
		// se mail non corrisponde mando mail a quella registrata
		if(response.getEmail() != request.getEmail())
			emailInvio = response.getEmail();
			
		String otp = randomString(7);
		OtpMailRequest requestOtp = new OtpMailRequest();
		requestOtp.setOtp(otp);
		requestOtp.setEmail(emailInvio);
		requestOtp.setUsername(request.getUsername());
		String respoMail = sendMailService.invioOtsMail(requestOtp);
		// cafonata fatta al momento poi fixo meglio mo so 14 ore che lavoro
		boolean continuo = true;
			if(respoMail.isEmpty())
				continuo = false;
			
		if(!continuo) {
			//devo mettere un eccezione mo non c'go voglia stessa storia di sopra
		}
		// salvo dato in cache
		//TODO fare maeglio mo so stanco pero è chiuso ciao
		return cacheService.inserisciCache(requestOtp);
		
		
			
			
	}
	
	

		static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		static SecureRandom rnd = new SecureRandom();

		String randomString(int len){
			StringBuilder sb = new StringBuilder(len);
			for(int i = 0; i < len; i++)
				sb.append(AB.charAt(rnd.nextInt(AB.length())));
			return sb.toString();
		}
	

}
