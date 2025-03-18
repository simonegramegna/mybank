package it.demo.mybank.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.demo.mybank.dto.IndirizzoDTO;
import it.demo.mybank.dto.IndirizzoIdDTO;
import it.demo.mybank.entity.Indirizzo;
import it.demo.mybank.repository.IndirizzoDAO;
import it.demo.mybank.utility.Utility4Indirizzo;

@Service
public class IndirizzoServiceImpl implements IndirizzoService{

    @Autowired
    private Utility4Indirizzo utilityIndirizzo;

    @Autowired
    private IndirizzoDAO dao;

    @Override
    public IndirizzoIdDTO leggiIndirizzo(Integer id) {

        Optional<Indirizzo> optional = dao.findById(id);
        IndirizzoIdDTO indirizzoIdDTO = null;

        if(optional.isPresent()){ 
            Indirizzo indirizzo = optional.get();

            indirizzoIdDTO = utilityIndirizzo.daIndirizzoAIndirizzoIdDTO(indirizzo);
        }
        
        return indirizzoIdDTO;
    }

    @Override
    public IndirizzoIdDTO registraIndirizzo(IndirizzoDTO indirizzo) {

        IndirizzoIdDTO indirizzoIdDTO = new IndirizzoIdDTO();
       
        if(indirizzo == null){
            return null;
        }

        Indirizzo indirizzoRegistrato = dao.save(utilityIndirizzo.daIndirizzoDTOAIndirizzo(indirizzoIdDTO));
        return utilityIndirizzo.daIndirizzoAIndirizzoIdDTO(indirizzoRegistrato);
    }

    @Override
    public void cancellaIndirizzo(Integer id) {
        
    }

}
