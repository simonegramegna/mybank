package it.demo.mybank.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.demo.mybank.dto.ContoCorrenteDTO;
import it.demo.mybank.dto.DatiAperturaContoDTO;
import it.demo.mybank.entity.ContoCorrente;
import it.demo.mybank.entity.Movimento;
import it.demo.mybank.entity.TipoMovimento;
import it.demo.mybank.entity.Utente;
import it.demo.mybank.repository.ContoCorrenteDAO;
import it.demo.mybank.repository.ContoCorrenteDAOImpl;
import it.demo.mybank.repository.UtenteDAO;
import it.demo.mybank.utility.Utility4Conto;

@Service
public class ContoCorrenteServiceImpl implements ContoCorrenteService {

    @Autowired
    private UtenteDAO daoUtente;

    @Autowired
    private ContoCorrenteDAO daoContoCorrente;

    @Autowired
    private Utility4Conto utilityConto;

    @Override
    public ContoCorrenteDTO apriConto(DatiAperturaContoDTO dto) {
        
        if(dto.getSaldo() < 0){
            throw new RuntimeException("saldo negativo " + dto.getSaldo());
        }

        if(dto.getIdProprietario() == null){
            throw new RuntimeException("id proprietario mancante " + dto.getIdProprietario());
        }

       Utente utenteProprietario = daoUtente.findById(dto.getIdProprietario());

        if(utenteProprietario == null){
            throw new RuntimeException("utente proprietario mancante " + dto.getIdProprietario());
        }

        Utente utenteCointestato = null;

        if(dto.getIdCointestatario() != null){
            utenteCointestato = daoUtente.findById(dto.getIdCointestatario());
        }

        ContoCorrente cc = new ContoCorrente(dto.getSaldo(), LocalDate.now());

        if(dto.getSaldo()>0) {
			int n = ContoCorrenteDAOImpl.getNumeroMovimento();
			Movimento m = new Movimento(n, TipoMovimento.VERSAMENTO, dto.getSaldo(),LocalDate.now(), utenteProprietario);
			cc.addMovimento(m);
		}

        cc.addProprietario(true, utenteProprietario);

        if(utenteCointestato != null){
            cc.addProprietario(false, utenteCointestato);
        }

        daoContoCorrente.save(cc);

        return utilityConto.daContoCorrenteAContoCorrenteDTO(cc);
    }

}
