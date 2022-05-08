package com.the.simone.seor.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.the.simone.seor.model.error.BaseError;
import com.the.simone.seor.model.error.OtpError;

@RestControllerAdvice
public class ErrorController {

	
	// utente error handler
	@ExceptionHandler(OtpError.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ResponseBody
	public BaseError handleNoRecordFoundException(OtpError ex) 
	{

		BaseError response = new BaseError();
		response.setErrDescr("Errore generazione otp");
		response.setErrId("Otp_01");
		response.setErrType("generationOtp_error");
		response.setError(true);
	    
	    return response;
	}
}
