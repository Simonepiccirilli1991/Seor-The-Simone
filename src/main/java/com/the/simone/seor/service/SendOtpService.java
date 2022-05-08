package com.the.simone.seor.service;

import java.security.SecureRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.the.simone.seor.fragment.CacheService;
import com.the.simone.seor.fragment.SendMailService;
import com.the.simone.seor.model.error.OtpError;
import com.the.simone.seor.model.request.CheckOtpRequest;
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



	public SendOtpResponse sendOts(SendOtpRequest request, String username) throws OtpError{

		LoginResponse response = loginService.infoUtente(username);
		String emailInvio = request.getEmail();
		// se mail non corrisponde mando mail a quella registrata
		if(response.getEmail() != request.getEmail())
			emailInvio = response.getEmail();
			
		String otp = randomString(7);
		OtpMailRequest requestOtp = new OtpMailRequest();
		requestOtp.setOtp(otp);
		requestOtp.setEmail(emailInvio);
		requestOtp.setUsername(username);
		String respoMail = sendMailService.invioOtsMail(requestOtp);
		// cafonata fatta al momento poi fixo meglio mo so 14 ore che lavoro
		boolean continuo = true;
			if(respoMail.isEmpty())
				continuo = false;
			
		if(!continuo) {
			throw new OtpError();
		}
		// salvo dato in cache
		SendOtpResponse oResponse = new SendOtpResponse();
		try {
		oResponse = cacheService.inserisciCache(requestOtp);
		}catch(Exception e) {
			throw new OtpError();
		}
		
		return oResponse;			
	}
	
	// checkOtp
	public String checkOtp(CheckOtpRequest request, String username) {
		
		request.setUsername(username);
		String response = cacheService.checkOtp(request);
		return response;
	}
	// cancella operazione cache
	public String cancellaOperazione(long transactionId) {
		String response = cacheService.cancellaCache(transactionId);
		return response;
		
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
