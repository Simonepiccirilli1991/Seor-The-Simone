package com.the.simone.seor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.the.simone.seor.model.Anagrafica;
import com.the.simone.seor.model.request.LoginInfoRequest;
import com.the.simone.seor.model.request.LoginRequest;
import com.the.simone.seor.model.request.RegistraUtenteStep1Request;
import com.the.simone.seor.model.request.RegistraUtenteStep2Request;
import com.the.simone.seor.model.response.InserisciUtenteResponse;
import com.the.simone.seor.model.response.LoginResponse;
import com.the.simone.seor.service.LoginService;
import com.the.simone.seor.service.RegistraAnagraficaService;
import com.the.simone.seor.service.RegistrautenteService;

@RestController
@RequestMapping("seor")
@CrossOrigin(origins = "http://localhost:4200")
public class DbController {

	@Autowired
	private RegistrautenteService utenteService;
	@Autowired
	private RegistraAnagraficaService anagraficaService;
	@Autowired
	private LoginService loginService;

	// insertimento utente
	@PostMapping("/inserisci/utente")
	public InserisciUtenteResponse inserisciUtenteStep1(@RequestBody RegistraUtenteStep1Request request) {

		InserisciUtenteResponse response = utenteService.inseriSciUtente(request);

		return response;


	}
	// inserimento anagrafica
	@PostMapping("/inserisci/anagrafica/{username}")
	public String inserisciAnagrafica(@PathVariable(value = "username") String username , @RequestBody Anagrafica request) {

		RegistraUtenteStep2Request iRequest = new RegistraUtenteStep2Request();

		iRequest.setAnagrafica(request);
		iRequest.setUsername(username);

		String response = anagraficaService.inserisciAnagrafica(iRequest);

		return response;

	}
	// login
	@PostMapping("/login/utente")
	public boolean login(@RequestBody LoginRequest request) {

		boolean response = loginService.checkPsw(request);

		return response;
	}
	// prova login , non in uso
	@PostMapping("/accedi/{username}")
	public LoginResponse accediUtente(@PathVariable(value = "username") String username) {

		LoginResponse response = loginService.loginUtente(username);

		return response;

	}
	// get info utente 
	@PostMapping("/get/infos")
	public LoginResponse infoUtente(@RequestBody LoginInfoRequest username) {

		LoginResponse response = loginService.infoUtente(username.getUsername());

		return response;

	}
	// prova, non in uso
	@GetMapping("/get/info/{username}")
	public LoginResponse infoUtente2(@PathVariable(value = "username") String username) {

		LoginResponse response = loginService.infoUtente(username);

		return response;

	}


}
