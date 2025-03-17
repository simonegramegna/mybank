package it.demo.mybank.service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.demo.mybank.dto.ContoCorrenteDTO;
import it.demo.mybank.dto.DatiAperturaContoDTO;
import it.demo.mybank.entity.ContoCorrente;
import it.demo.mybank.entity.Movimento;
import it.demo.mybank.entity.Utente;
import it.demo.mybank.repository.ContoCorrenteDAO;
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
        /* 
        
        if(dto.getSaldo() < 0){
            throw new RuntimeException("saldo negativo " + dto.getSaldo());
        }

        if(dto.getIdProprietario() == null){
            throw new RuntimeException("id proprietario mancante " + dto.getIdProprietario());
        }

       Optional<Utente> utenteProprietario = daoUtente.findById(dto.getIdProprietario());

        if(utenteProprietario == null){
            throw new RuntimeException("utente proprietario mancante " + dto.getIdProprietario());
        }

        Optional<Utente> utenteCointestato = null;

        if(dto.getIdCointestatario() != null){
            utenteCointestato = daoUtente.findById(dto.getIdCointestatario());
        }

        ContoCorrente cc = new ContoCorrente(dto.getSaldo(), LocalDate.now());

        if(dto.getSaldo()>0) {
			//int n = ContoCorrenteDAOImpl.getNumeroMovimento();
			Movimento m = new Movimento();
			cc.addMovimento(m);
		}

        cc.addProprietario(true, utenteProprietario);

        if(utenteCointestato != null){
            cc.addProprietario(false, utenteCointestato);
        }

        daoContoCorrente.save(cc);

        return utilityConto.daContoCorrenteAContoCorrenteDTO(cc);
        */
        return null;
    }

    @Override
    public ContoCorrenteDTO modificaSaldo(Integer numeroConto, Double newSaldo, Integer idUtenteOperatore) {

        /* 
        if(newSaldo < 0){
            throw new RuntimeException("Il nuovo saldo non può essere negativo!");
        }

        ContoCorrente cc = daoContoCorrente.findById(numeroConto);

        if(cc == null){
            throw new RuntimeException("Il conto corrente non esiste nel db!");
        }

        if(utilityConto.proprietarioCC(cc, idUtenteOperatore) == false){
            throw new RuntimeException("Propreitario e id utente non coincidono");
        }

        cc.setSaldo(newSaldo);

        //int n = ContoCorrenteDAOImpl.getNumeroMovimento();
        Movimento movimento = new Movimento();
        cc.addMovimento(movimento);
        daoContoCorrente.save(cc);

        return utilityConto.daContoCorrenteAContoCorrenteDTO(cc); */

        return null;
    }

    @Override
    public ContoCorrenteDTO leggiConto(Integer numeroConto) {
        
        /* 
        ContoCorrente cc = daoContoCorrente.findById(numeroConto);
        
        if(cc == null){
            throw new RuntimeException("Il conto non esiste");
        }
        
        return utilityConto.daContoCorrenteAContoCorrenteDTO(cc); */
        return null;
    }

    @Override
    public void cancellaConto(Integer numeroConto) {
        
        /* 
        ContoCorrente contoCancellato = daoContoCorrente.findById(numeroConto);

        if(contoCancellato == null){
            throw new RuntimeException("Il conto non esiste!");
        }

        if(contoCancellato.getSaldo() != 0){
            throw new RuntimeException("Il saldo deve essere zero!");
        }

        contoCancellato.getMovimenti().clear();
        contoCancellato.getProprietari().clear();
        
        daoContoCorrente.removeById(numeroConto); */

    }
}
