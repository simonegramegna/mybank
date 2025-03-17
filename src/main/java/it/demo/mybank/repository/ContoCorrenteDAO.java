package it.demo.mybank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.demo.mybank.entity.ContoCorrente;

public interface ContoCorrenteDAO extends JpaRepository<ContoCorrente, Integer> {
    
    
}
