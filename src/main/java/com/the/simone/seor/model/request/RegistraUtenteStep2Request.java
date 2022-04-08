package com.the.simone.seor.model.request;

import com.the.simone.seor.model.Anagrafica;

public class RegistraUtenteStep2Request {
	
	private String username;
	
	private Anagrafica anagrafica;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Anagrafica getAnagrafica() {
		return anagrafica;
	}

	public void setAnagrafica(Anagrafica anagrafica) {
		this.anagrafica = anagrafica;
	}
	
	

}
