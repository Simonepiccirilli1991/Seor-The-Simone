package com.the.simone.seor.model.request;


public class RegistraUtenteStep1Request {
	
	private  String username;
	private  String psw;
	private  String email;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPsw() {
		return psw;
	}
	public void setPsw(String psw) {
		this.psw = psw;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
	



//	public static class RegistraUtenteBuilder {
//		
//		//utente
//		private final String username;
//		private final String psw;
//		private final String email;
//		
//		
//		
//		public RegistraUtenteBuilder(String username, String psw, String email) {
//			this.username = username;
//			this.psw = psw;
//			this.email = psw;
//		}
//		
//		}
		
//		public RegistraUtenteStep1Request build() {
//			return new RegistraUtenteStep1Request(this);
//		}


