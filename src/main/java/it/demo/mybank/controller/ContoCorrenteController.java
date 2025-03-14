package it.demo.mybank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.demo.mybank.dto.ContoCorrenteDTO;
import it.demo.mybank.dto.DatiAperturaContoDTO;
import it.demo.mybank.service.ContoCorrenteService;

@RestController
@RequestMapping(path="/conti")
public class ContoCorrenteController {

    @Autowired
    private ContoCorrenteService service;

    @PostMapping(path="", consumes = MediaType.APPLICATION_JSON_VALUE, 
						  produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ContoCorrenteDTO apriConto(@RequestBody DatiAperturaContoDTO dto) {
        
		System.out.println(dto);
		return service.apriConto(dto);
	}

	@PatchMapping(path="/{numeroConto}/saldo")
	public ContoCorrenteDTO modificaSaldoConto(@PathVariable Integer numeroConto, Double newSaldo, Integer idUtenteOperatore){
		
		return service.modificaSaldo(numeroConto, newSaldo, idUtenteOperatore);
	}

}
