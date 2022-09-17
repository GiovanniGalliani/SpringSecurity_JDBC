package com.academy.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.academy.security.repository.UtenteRepository;

@Configuration
public class JdbcSecurityConfig extends WebSecurityConfigurerAdapter {
	private UtenteRepository utenteRepository;
	
	public JdbcSecurityConfig(UtenteRepository personaRepository) {
		this.utenteRepository = personaRepository;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/**").hasRole("ADMIN").and().httpBasic();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(new JdbcUserDetailsService(utenteRepository));
	}
	
	
}
