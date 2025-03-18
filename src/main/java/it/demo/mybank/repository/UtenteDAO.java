package it.demo.mybank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.demo.mybank.entity.Utente;

public interface UtenteDAO extends JpaRepository<Utente, Integer> {
	
}