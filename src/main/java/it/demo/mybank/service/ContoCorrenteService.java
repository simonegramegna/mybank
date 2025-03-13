package it.demo.mybank.service;

import it.demo.mybank.dto.ContoCorrenteDTO;
import it.demo.mybank.dto.DatiAperturaContoDTO;

public interface ContoCorrenteService {

    public ContoCorrenteDTO apriConto(DatiAperturaContoDTO dto);
}
