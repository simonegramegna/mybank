package it.demo.mybank.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.demo.mybank.dto.IndirizzoDTO;
import it.demo.mybank.dto.IndirizzoIdDTO;
import it.demo.mybank.service.IndirizzoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping(path = "/indirizzo")
public class IndirizzoController {

    @Autowired
    private IndirizzoService service;

    @PostMapping(path = "/registra", consumes = MediaType.APPLICATION_JSON_VALUE, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public IndirizzoDTO registraIndirizzoDTO(IndirizzoDTO indirizzoDTO) {

        return service.registraIndirizzo(indirizzoDTO);
    }

    @GetMapping(path = "/getById/{id}")
    public IndirizzoIdDTO leggiIndirizzo(@PathVariable Integer id) {

        return service.leggiIndirizzo(id);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void eliminaIndirizzo(@PathVariable Integer id){ 
        
        service.cancellaIndirizzo(id);
    }
    
    

}
