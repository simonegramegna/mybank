package it.demo.mybank.utility;

import org.springframework.stereotype.Component;

import it.demo.mybank.dto.UtenteDTO;
import it.demo.mybank.dto.UtenteIdDTO;
import it.demo.mybank.entity.Utente;

@Component
public class Utility4Utente {

    public UtenteDTO daUtenteAUtenteDTO(Utente utente){

        if(utente == null){
            return null;
        }

        UtenteDTO utenteDTO = new UtenteDTO();

        utenteDTO.setNome(utente.getNome());
        utenteDTO.setCognome(utente.getCognome());
        utenteDTO.setMail(utente.getMail());
        utenteDTO.setTelefono(utente.getTelefono());

        return utenteDTO;
    }

    public Utente daUtenteDTOAUtente(UtenteDTO utenteDTO){
        
        if(utenteDTO == null){
            return null;
        }

        Utente utente = new Utente();
    
        utente.setNome(utenteDTO.getNome());
        utente.setCognome(utenteDTO.getCognome());
        utente.setMail(utenteDTO.getMail());
        utente.setTelefono(utenteDTO.getTelefono());

        return utente;
    }

    public UtenteIdDTO daUtenteAUtenteIdDTO(Utente utente){

        if(utente == null){
            return null;
        }

        UtenteIdDTO utenteIdDTO = new UtenteIdDTO();

        utenteIdDTO.setIdUtente(utente.getIdUtente());
        utenteIdDTO.setNome(utente.getNome());
        utenteIdDTO.setCognome(utente.getCognome());
        utenteIdDTO.setMail(utente.getMail());
        utenteIdDTO.setTelefono(utente.getTelefono());

        return utenteIdDTO;
    }

    public Utente daUtenteIdDTOAUtente(UtenteIdDTO utenteIdDTO){

        if(utenteIdDTO == null){
            return null;
        }

        Utente utente = new Utente();

        utente.setIdUtente(utenteIdDTO.getIdUtente());
        utente.setNome(utenteIdDTO.getNome());
        utente.setCognome(utenteIdDTO.getCognome());
        utente.setMail(utenteIdDTO.getMail());
        utente.setTelefono(utenteIdDTO.getTelefono());

        return utente;
    }

}
