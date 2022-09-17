package com.academy.security.service;


import com.academy.security.model.Utente;

public interface UtenteService {
	Utente findByEmailIgnoreCase(String email);
}
