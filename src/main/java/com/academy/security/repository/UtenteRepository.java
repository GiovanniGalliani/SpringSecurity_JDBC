package com.academy.security.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.academy.security.model.Utente;

@Repository("utenteRepository")
public interface UtenteRepository extends CrudRepository<Utente, Long>{
	public Utente findByEmailIgnoreCase(@Param("email") String email);
}
