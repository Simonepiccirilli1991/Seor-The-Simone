package com.the.simone.seor.model.response;

import com.the.simone.seor.model.Anagrafica;
import com.the.simone.seor.model.request.RegistraUtenteStep1Request;

public class LoginResponse extends RegistraUtenteStep1Request{
	
	private Anagrafica anagrafica;
	private boolean isError;
	private String errId;

	

	public Anagrafica getAnagrafica() {
		return anagrafica;
	}

	public void setAnagrafica(Anagrafica anagrafica) {
		this.anagrafica = anagrafica;
	}

	public boolean isError() {
		return isError;
	}

	public void setError(boolean isError) {
		this.isError = isError;
	}

	public String getErrId() {
		return errId;
	}

	public void setErrId(String errId) {
		this.errId = errId;
	}
	
	
	
	

}
