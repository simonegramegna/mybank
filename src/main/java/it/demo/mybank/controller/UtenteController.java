package it.demo.mybank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.demo.mybank.dto.UtenteDTO;
import it.demo.mybank.dto.UtenteIdDTO;
import it.demo.mybank.service.UtenteService;

@RestController
@RequestMapping(path="/utenti")
public class UtenteController {

    @Autowired
    private UtenteService service;

    @PostMapping(path = "/registra", consumes = MediaType.APPLICATION_JSON_VALUE, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public UtenteDTO registraUtente(@RequestBody UtenteDTO dto) {
		System.out.println("invocato il metodo registraUtente di UserController");
		return service.registraNuovoUtente(dto);
	}
	
	@GetMapping(path = "/getAll", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public List<UtenteIdDTO> leggiTuttiUtenti() {
		System.out.println("invocato il metodo leggiTuttiUtenti di UserController");
		return service.leggiTuttiUtenti();
	}

	@GetMapping(path = "/getById/{id}")
	public UtenteIdDTO leggiUtente(@PathVariable Integer id) {
		return service.leggiUtente(id);
	}
	

}
