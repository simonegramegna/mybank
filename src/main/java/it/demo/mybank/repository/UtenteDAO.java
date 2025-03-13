package it.demo.mybank.repository;

import java.util.List;

import it.demo.mybank.entity.Utente;

public interface UtenteDAO {
	
	public void save(Utente u);
	public Utente findById(int id);
	public List<Utente> findAll();
}