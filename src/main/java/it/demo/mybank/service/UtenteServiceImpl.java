package it.demo.mybank.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.demo.mybank.dto.UtenteDTO;
import it.demo.mybank.dto.UtenteIdDTO;
import it.demo.mybank.entity.Utente;
import it.demo.mybank.repository.UtenteDAO;
import it.demo.mybank.utility.Utility4Utente;

@Service
public class UtenteServiceImpl implements UtenteService{

    @Autowired
    private UtenteDAO dao;

    @Autowired
    private Utility4Utente utility;

    @Override
    public UtenteIdDTO registraNuovoUtente(UtenteDTO dto) {

        if(dto == null){
            return null;
        }

        if(dao.findByMail(dto.getMail()) != null){
            throw new RuntimeException("Esiste un utente con questa mail!");
        }
        
        Utente utenteRegistrato = dao.save(utility.daUtenteDTOAUtente(dto));

        return utility.daUtenteAUtenteIdDTO(utenteRegistrato);   
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
