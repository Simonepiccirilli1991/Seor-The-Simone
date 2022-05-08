package com.the.simone.seor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.the.simone.seor.model.request.CheckOtpRequest;
import com.the.simone.seor.model.request.MorraRequest;
import com.the.simone.seor.model.request.SendOtpRequest;
import com.the.simone.seor.model.response.SendOtpResponse;
import com.the.simone.seor.service.MorraService;
import com.the.simone.seor.service.SendOtpService;

@RestController
@RequestMapping("nodb")
@CrossOrigin(origins = "http://localhost:4200")
public class NoDbController {
	
	@Autowired
	private MorraService morraService;
	@Autowired
	private SendOtpService sendOtp;
	
	@RequestMapping("/morra")
	public String morra(@RequestBody MorraRequest request){
		
		
		return morraService.morraService(request.getVal1(), request.getVal2());
		
	}
	
	@PostMapping("/sendotp/{username}")
	public SendOtpResponse sendOtp(@PathVariable(value = "username") String username,@RequestBody SendOtpRequest request) {
		
		SendOtpResponse response = new SendOtpResponse();
		response = sendOtp.sendOts(request,username);
		return response;
		
	}
	//checkOtp
	@PostMapping("/checkotp/{username}")
	public String checkOtp(@PathVariable(value = "username") String username, @RequestBody CheckOtpRequest request) {
		String response = sendOtp.checkOtp(request,username);
		return response;
		
	}

}
