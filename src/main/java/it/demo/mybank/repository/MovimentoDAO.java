package it.demo.mybank.repository;

import java.util.List;

import it.demo.mybank.entity.Movimento;

public interface MovimentoDAO {

    public void save(Movimento m);
    public Movimento findById(int id);
    public List<Movimento> findAll();
}
