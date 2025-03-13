package it.demo.mybank.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import it.demo.mybank.entity.Movimento;

@Repository
public class MovimentoDAOImpl implements MovimentoDAO{

    @Override
    public void save(Movimento m) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public Movimento findById(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public List<Movimento> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

}
