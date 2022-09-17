package com.academy.security.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.academy.security.model.Utente;
import com.academy.security.repository.UtenteRepository;
import com.academy.security.service.UtenteService;

@Service("utenteService")
public class UtenteServiceImpl implements UtenteService {
	@Autowired
	private UtenteRepository utenteRepository;
	
	@Override
	public Utente findByEmailIgnoreCase(String email) {
		return utenteRepository.findByEmailIgnoreCase(email);
	}
	
}
