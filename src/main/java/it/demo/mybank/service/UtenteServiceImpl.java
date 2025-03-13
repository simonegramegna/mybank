package it.demo.mybank.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.demo.mybank.dto.UtenteDTO;
import it.demo.mybank.dto.UtenteIdDTO;
import it.demo.mybank.entity.Utente;
import it.demo.mybank.repository.UtenteDAO;

@Service
public class UtenteServiceImpl implements UtenteService{

    @Autowired
    private UtenteDAO dao;

    @Override
    public void registraNuovoUtente(UtenteDTO dto) {
       
        Utente u = new Utente();
        u.setNome(dto.getNome());
		u.setCognome(dto.getCognome());
		u.setMail(dto.getMail());
		u.setTelefono(dto.getTelefono());

		dao.save(u);
    }

    @Override
    public List<UtenteIdDTO> leggiTuttiUtenti() {
        
        List<Utente> listaUtenti = dao.findAll();
        List<UtenteIdDTO> lDto = new ArrayList<>();

		for (Utente u : listaUtenti) {
			lDto.add(new UtenteIdDTO(u.getIdUtente(), u.getNome(), u.getCognome(), u.getMail(), u.getTelefono()));
		}
        
		return lDto;
    }

}
