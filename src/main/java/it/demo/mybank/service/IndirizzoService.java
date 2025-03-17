package it.demo.mybank.service;

import it.demo.mybank.dto.IndirizzoDTO;

public interface IndirizzoService {

    public IndirizzoDTO leggiIndirizzo(int id);

    public void registraIndirizzo(IndirizzoDTO indirizzo);

}
