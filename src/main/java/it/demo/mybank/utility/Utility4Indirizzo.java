package it.demo.mybank.utility;

import org.springframework.stereotype.Component;
import it.demo.mybank.dto.IndirizzoDTO;
import it.demo.mybank.dto.IndirizzoIdDTO;
import it.demo.mybank.entity.Indirizzo;

@Component
public class Utility4Indirizzo {

    public IndirizzoDTO daIndirizzoAIndirizzoDTO(Indirizzo indirizzo){

        IndirizzoDTO indirizzoDTO = new IndirizzoDTO();

        if(indirizzo == null){
            return null;
        }

        indirizzoDTO.setVia(indirizzo.getVia());
        indirizzoDTO.setCitta(indirizzo.getCitta());
        indirizzoDTO.setCap(indirizzo.getCap());
        indirizzoDTO.setProvincia(indirizzo.getProvincia());
        
        return indirizzoDTO;
    }

    public Indirizzo daIndirizzoDTOAIndirizzo(IndirizzoDTO indirizzoDTO){

        Indirizzo indirizzo = new Indirizzo();

        if(indirizzoDTO == null){
            return null;
        }

        indirizzo.setVia(indirizzoDTO.getVia());
        indirizzo.setCitta(indirizzoDTO.getCitta());
        indirizzo.setCap(indirizzoDTO.getCap());
        indirizzo.setProvincia(indirizzoDTO.getProvincia());

        return indirizzo;
    }


    public IndirizzoIdDTO daIndirizzoAIndirizzoIdDTO(Indirizzo indirizzo){

        IndirizzoIdDTO indirizzoIdDTO = new IndirizzoIdDTO();

        if(indirizzo == null){
            return null;
        }

        indirizzoIdDTO.setIdIndirizzo(indirizzo.getIdIndirizzo());
        indirizzoIdDTO.setVia(indirizzo.getVia());
        indirizzoIdDTO.setCitta(indirizzo.getCitta());
        indirizzoIdDTO.setCap(indirizzo.getCap());
        indirizzoIdDTO.setProvincia(indirizzo.getProvincia());
        
        return indirizzoIdDTO;
    }


    public Indirizzo daIndrizzoIdDTOAIndirizzo(IndirizzoIdDTO indirizzoIdDTO){

        Indirizzo indirizzo = new Indirizzo();

        if(indirizzoIdDTO == null){ 
            return null;
        }

        indirizzo.setIdIndirizzo(indirizzoIdDTO.getIdIndirizzo());
        indirizzo.setVia(indirizzoIdDTO.getVia());
        indirizzo.setCitta(indirizzoIdDTO.getCitta());
        indirizzo.setCap(indirizzoIdDTO.getCap());
        indirizzo.setProvincia(indirizzoIdDTO.getProvincia());

        return indirizzo;
    }
}
