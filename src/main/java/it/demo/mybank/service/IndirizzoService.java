package it.demo.mybank.service;

import it.demo.mybank.dto.IndirizzoDTO;
import it.demo.mybank.dto.IndirizzoIdDTO;

public interface IndirizzoService {

    public IndirizzoIdDTO leggiIndirizzo(Integer id);

    public IndirizzoIdDTO registraIndirizzo(IndirizzoDTO indirizzo);

    public void cancellaIndirizzo(Integer id);
}
