package it.demo.mybank.service;

import java.util.List;

import it.demo.mybank.dto.UtenteDTO;
import it.demo.mybank.dto.UtenteIdDTO;

public interface UtenteService {

    public UtenteIdDTO registraNuovoUtente(UtenteDTO dto);

	public List<UtenteIdDTO> leggiTuttiUtenti();

    public UtenteIdDTO leggiUtente(int id);

    public void eliminaUtente(Integer id);
}
