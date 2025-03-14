package it.demo.mybank.repository;

import java.util.List;

import it.demo.mybank.entity.ContoCorrente;

public interface ContoCorrenteDAO {
    
    public void save(ContoCorrente cc);
	public ContoCorrente findById(int numero);
	public List<ContoCorrente> findAll();
	public void removeById(int numero);
}
