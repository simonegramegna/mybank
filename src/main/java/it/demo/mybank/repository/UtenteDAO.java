package it.demo.mybank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.demo.mybank.entity.Utente;

public interface UtenteDAO extends JpaRepository<Utente, Integer> {

    
    @Query("SELECT u FROM Utente u WHERE u.mail = :mail")
    public List<Utente> getUtenteMail(String mail);
	
}