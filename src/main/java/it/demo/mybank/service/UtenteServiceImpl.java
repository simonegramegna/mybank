package it.demo.mybank.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.demo.mybank.dto.UtenteDTO;
import it.demo.mybank.dto.UtenteIdDTO;
import it.demo.mybank.entity.Utente;
import it.demo.mybank.repository.UtenteDAO;
import it.demo.mybank.utility.Utility4Utente;

@Service
@Transactional
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

        /* query custom
        if(dao.findByMail(dto.getMail()) != null){
            throw new RuntimeException("Esiste un utente con questa mail!");
        }*/
        
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

    @Override
    public UtenteIdDTO leggiUtente(int id) {

        Optional<Utente> optional = dao.findById(id);
        UtenteIdDTO utenteIdDTO = null;

        if(optional.isPresent()){
            Utente utente = optional.get();
            utenteIdDTO = utility.daUtenteAUtenteIdDTO(utente);
        }
        return utenteIdDTO;
    }

}
