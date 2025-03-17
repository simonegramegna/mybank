package it.demo.mybank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.demo.mybank.entity.Movimento;

public interface MovimentoDAO extends JpaRepository<Movimento, Integer> {

}
