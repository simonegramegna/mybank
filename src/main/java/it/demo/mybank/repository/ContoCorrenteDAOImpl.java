package it.demo.mybank.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import it.demo.mybank.entity.ContoCorrente;

@Repository
public class ContoCorrenteDAOImpl implements ContoCorrenteDAO{

    private static int contatoreConto = 0;
	private static int contatoreMovimento = 0;

    private Map<Integer, ContoCorrente> conti = new HashMap<Integer, ContoCorrente>();

    public static int getNumeroMovimento() {
		contatoreMovimento++;
		return contatoreMovimento;
	}


    @Override
    public void save(ContoCorrente cc) {
        contatoreConto++;
		cc.setNumero(contatoreConto);
		conti.put(contatoreConto, cc);
    }

    @Override
    public ContoCorrente findById(int numero) {
        return conti.get(numero);
    }

    @Override
    public List<ContoCorrente> findAll() {
        return new ArrayList<>(conti.values());
    }


    @Override
    public void removeById(int numero) {
        conti.remove(numero);
    }

}
