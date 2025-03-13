package it.demo.mybank.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import it.demo.mybank.entity.Utente;

@Repository
public class UtenteDAOImpl implements UtenteDAO {

    private static int contatoreUtente = 0;
    private Map<Integer, Utente> utenti = new HashMap<>();

    @Override
    public Utente save(Utente u) {
        contatoreUtente++;
		u.setIdUtente(contatoreUtente);
		utenti.put(contatoreUtente, u);

        return u;
    }

    @Override
    public Utente findById(int id) {
        return utenti.get(id);
    }

    @Override
    public List<Utente> findAll() {
        return new ArrayList<>(utenti.values());
    }

    @Override
    public Utente findByMail(String mail) {
        Utente utente = null;

        for(Utente u : utenti.values()){
            if(u.getMail().equals(mail)){
                utente = u;
                break;
            }
        }
        return utente;
    }

}
