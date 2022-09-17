package com.academy.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.academy.security.model.Utente;
import com.academy.security.service.UtenteService;

@RestController
@RequestMapping("/api")
public class UtenteRestController {
	
	@Autowired
	private UtenteService utenteService;
	
	@GetMapping("/search/{email}")
	public Utente getUtente(@PathVariable String email) {
		return utenteService.findByEmailIgnoreCase(email);
	}
}