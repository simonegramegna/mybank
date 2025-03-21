package it.demo.mybank.service;

import it.demo.mybank.dto.ContoCorrenteDTO;
import it.demo.mybank.dto.DatiAperturaContoDTO;

public interface ContoCorrenteService {

    public ContoCorrenteDTO apriConto(DatiAperturaContoDTO dto);

    public ContoCorrenteDTO modificaSaldo(Integer numeroConto, Double newSaldo, Integer idUtenteOperatore);

    public ContoCorrenteDTO leggiConto(Integer numeroConto);

    public void cancellaConto(Integer numeroConto);

    public String validitaConto(Integer numeroConto);
}
