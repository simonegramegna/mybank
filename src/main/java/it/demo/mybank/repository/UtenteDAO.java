package it.demo.mybank.repository;

import java.util.List;

import it.demo.mybank.entity.Utente;

public interface UtenteDAO {
	
	public Utente save(Utente u);
	public Utente findById(int id);
	public Utente findByMail(String mail);
	public List<Utente> findAll();
}