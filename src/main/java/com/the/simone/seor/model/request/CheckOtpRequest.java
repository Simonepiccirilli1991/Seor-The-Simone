package com.the.simone.seor.model.request;

public class CheckOtpRequest {

	private String username;
	private String otp;
	private long transactionId;
	
	
	public CheckOtpRequest(String otp, long transactionId) {
		super();
		this.otp = otp;
		this.transactionId = transactionId;
	}


	public String getOtp() {
		return otp;
	}

	public long getTransactionId() {
		return transactionId;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}
	
}
