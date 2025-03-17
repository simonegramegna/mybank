package it.demo.mybank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.demo.mybank.entity.Indirizzo;

public interface IndirizzoDAO extends JpaRepository<Indirizzo, Integer>{

}
