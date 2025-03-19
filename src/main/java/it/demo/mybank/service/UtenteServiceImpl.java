package it.demo.mybank.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.demo.mybank.dto.UtenteDTO;
import it.demo.mybank.dto.UtenteIdDTO;
import it.demo.mybank.entity.ContoCorrente;
import it.demo.mybank.entity.Indirizzo;
import it.demo.mybank.entity.Utente;
import it.demo.mybank.repository.ContoCorrenteDAO;
import it.demo.mybank.repository.UtenteDAO;
import it.demo.mybank.utility.Utility4Indirizzo;
import it.demo.mybank.utility.Utility4Utente;

@Service
@Transactional
public class UtenteServiceImpl implements UtenteService{

    @Autowired
    private UtenteDAO dao;

    @Autowired
    private ContoCorrenteDAO daoCC;

    @Autowired
    private Utility4Utente utilityUtente;

    @Autowired
    private Utility4Indirizzo utilityIndirizzo;

    @Override
    public UtenteIdDTO registraNuovoUtente(UtenteDTO dto) {

        if(dto == null){
            return null;
        }

        
        if(dao.getUtenteMail(dto.getMail()).isEmpty() == false){
            throw new RuntimeException("Esiste un utente con questa mail!");
        }
        
        Utente utenteRegistrato = dao.save(utilityUtente.daUtenteDTOAUtente(dto));

        return utilityUtente.daUtenteAUtenteIdDTO(utenteRegistrato);   
    }

    @Override
    public List<UtenteIdDTO> leggiTuttiUtenti() {
        
        List<Utente> listaUtenti = dao.findAll();
        List<UtenteIdDTO> lDto = new ArrayList<>();

        for (Utente u : listaUtenti) {

            Indirizzo indirizzo = u.getResidenza();
            UtenteIdDTO utente = new UtenteIdDTO(u.getIdUtente(), u.getNome(), u.getCognome(), u.getMail(), u.getTelefono(), utilityIndirizzo.daIndirizzoAIndirizzoDTO(indirizzo));

            lDto.add(utente);
        }
        
        return lDto;
    }

    @Override
    public UtenteIdDTO leggiUtente(int id) {

        Optional<Utente> optional = dao.findById(id);
        UtenteIdDTO utenteIdDTO = null;

        if(optional.isPresent()){
            Utente utente = optional.get();
            utenteIdDTO = utilityUtente.daUtenteAUtenteIdDTO(utente);
        }
        return utenteIdDTO;
    }

    @Override
    public void eliminaUtente(Integer id) {

        Optional<Utente> optional = dao.findById(id);
        boolean check = false;

        if(optional.isEmpty()){ 
            throw new RuntimeException("L'utente non esiste");
        }

        List<ContoCorrente> conti = daoCC.findAll();

        for(ContoCorrente c : conti){ 
            if(c.getProprietari().containsValue(optional.orElse(null))){ 
                check = true;
                break;
            }
        }

        if(check){ 
            throw new RuntimeException(
                    "Impossibile cancellare l'utente con ID " + id + " perché ha conti correnti associati.");
        }

        dao.deleteById(id);
    }
}
