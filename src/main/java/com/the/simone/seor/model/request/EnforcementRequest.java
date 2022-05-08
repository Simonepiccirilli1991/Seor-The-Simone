package com.the.simone.seor.model.request;

import com.the.simone.seor.model.Sicurezza;

public class EnforcementRequest {

	private String username;
	private Sicurezza sicurezza;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Sicurezza getSicurezza() {
		return sicurezza;
	}
	public void setSicurezza(Sicurezza sicurezza) {
		this.sicurezza = sicurezza;
	}
	
	
}
