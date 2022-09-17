package com.academy.security.config;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.academy.security.model.Utente;
import com.academy.security.repository.UtenteRepository;

public class JdbcUserDetailsService implements UserDetailsService {
	private UtenteRepository repo;
	
	public JdbcUserDetailsService (UtenteRepository repo) {
		this.repo = repo;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		try {
			Utente utente = this.repo.findByEmailIgnoreCase(email);
			if(utente !=null) {
				PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
				String password = encoder.encode(utente.getPassword());
				return User.withUsername(
					      utente.getEmail())
					      .accountLocked(!utente.isEnabled())
					      .password(password)
					      .roles(utente.getRuolo())
					      .build();
			}
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		throw new UsernameNotFoundException(email);
	}
}
