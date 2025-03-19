package it.demo.mybank.service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.demo.mybank.dto.ContoCorrenteDTO;
import it.demo.mybank.dto.DatiAperturaContoDTO;
import it.demo.mybank.entity.ContoCorrente;
import it.demo.mybank.entity.Movimento;
import it.demo.mybank.entity.TipoMovimento;
import it.demo.mybank.entity.Utente;
import it.demo.mybank.repository.ContoCorrenteDAO;
import it.demo.mybank.repository.MovimentoDAO;
import it.demo.mybank.repository.UtenteDAO;
import it.demo.mybank.utility.Utility4Conto;

@Service
public class ContoCorrenteServiceImpl implements ContoCorrenteService {

    private static final double LIMITE_MINIMO = -5000;
    private static final double MORA_PERCENTUALE = 0.05;

    @Autowired
    private MovimentoDAO movimentoDAO;

    @Autowired
    private UtenteDAO daoUtente;

    @Autowired
    private ContoCorrenteDAO daoContoCorrente;

    @Autowired
    private Utility4Conto utilityConto;

    private static double calcolaMora(Double vecchioSaldo, Double newSaldo){ 

        double mora = 0;

        if(newSaldo < vecchioSaldo){ 
            
            mora = Math.abs(newSaldo) * MORA_PERCENTUALE;
        }

        if(newSaldo > vecchioSaldo){ 

            mora = (newSaldo - Math.abs(vecchioSaldo))*MORA_PERCENTUALE;
        }
        return mora;
    }

    @Override
    public ContoCorrenteDTO apriConto(DatiAperturaContoDTO dto) {
        
        
        if(dto.getSaldo() < 0){
            throw new RuntimeException("saldo negativo " + dto.getSaldo());
        }

        if(dto.getIdProprietario() == null){
            throw new RuntimeException("id proprietario mancante " + dto.getIdProprietario());
        }

        Utente utenteProprietario = daoUtente.findById(dto.getIdProprietario()).get();

        if(utenteProprietario == null){
            throw new RuntimeException("utente proprietario mancante " + dto.getIdProprietario());
        }

        Utente utenteCointestato = null;

        if(dto.getIdCointestatario() != null){
            utenteCointestato = daoUtente.findById(dto.getIdCointestatario()).get();
        }

        ContoCorrente cc = new ContoCorrente(dto.getSaldo(), LocalDate.now());

        if(dto.getSaldo()>0) {
			Movimento movimento = new Movimento();

            movimento.setTipo(TipoMovimento.VERSAMENTO);
            movimento.setImporto(dto.getSaldo());
			movimento.setDataOperazione(LocalDate.now());
            movimento.setOperatore(utenteProprietario);

            cc.addMovimento(movimento);
            movimentoDAO.save(movimento);
		}

        cc.addProprietario(true, utenteProprietario);

        if(utenteCointestato != null){
            cc.addProprietario(false, utenteCointestato);
        }

        daoContoCorrente.save(cc);

        return utilityConto.daContoCorrenteAContoCorrenteDTO(cc);
    }

    @Override
    public ContoCorrenteDTO modificaSaldo(Integer numeroConto, Double newSaldo, Integer idUtenteOperatore) {
        
        Optional<ContoCorrente> optionalCC = daoContoCorrente.findById(numeroConto);
        Optional<Utente> optionalUtente = daoUtente.findById(idUtenteOperatore);

        if(optionalCC.isEmpty()){ 
            throw new RuntimeException("Il conto non esiste!");
        }

        if(optionalUtente.isEmpty()){ 
            throw new RuntimeException("L'utente non esiste!");
        }

        ContoCorrente cc = optionalCC.get();
        Utente utenteOperatore = optionalUtente.get();

        if(cc.getProprietari().containsValue(utenteOperatore) == false){ 
            throw new RuntimeException("L'utente non è tra i proprietari del conto!");
        }

        double saldoVecchio = cc.getSaldo();

        if(saldoVecchio == newSaldo){ 
            return utilityConto.daContoCorrenteAContoCorrenteDTO(cc);
        }

        TipoMovimento tipo = TipoMovimento.VERSAMENTO;

        if(newSaldo < saldoVecchio){ 

            tipo = TipoMovimento.PRELIEVO;
        }

        double mora = calcolaMora(saldoVecchio, newSaldo);
        double differenza = Math.abs(saldoVecchio-newSaldo);

        Movimento movimento = new Movimento();
        
        movimento.setOperatore(utenteOperatore);
        movimento.setTipo(tipo);
        movimento.setImporto(differenza);
        movimento.setDataOperazione(LocalDate.now());

        newSaldo = newSaldo - mora;

        if(newSaldo < LIMITE_MINIMO){ 
            throw new RuntimeException("Il conto è sotto il limite minimo");
        }

        Movimento movimentoMora = new Movimento();

        movimentoMora.setOperatore(utenteOperatore);
        movimentoMora.setTipo(TipoMovimento.PRELIEVO);
        movimentoMora.setImporto(mora);
        movimentoMora.setDataOperazione(LocalDate.now());


        cc.addMovimento(movimento);
        cc.addMovimento(movimentoMora);
        cc.setSaldo(newSaldo);

        movimentoDAO.save(movimento);
        movimentoDAO.save(movimentoMora);
        daoContoCorrente.save(cc);
        
        return utilityConto.daContoCorrenteAContoCorrenteDTO(cc);
    }

    @Override
    public ContoCorrenteDTO leggiConto(Integer numeroConto) {
        
        
        ContoCorrente cc = daoContoCorrente.findById(numeroConto).get();
        
        if(cc == null){
            throw new RuntimeException("Il conto non esiste");
        }
        
        return utilityConto.daContoCorrenteAContoCorrenteDTO(cc);
    }

    @Override
    public void cancellaConto(Integer numeroConto) {

        Optional<ContoCorrente> optional = daoContoCorrente.findById(numeroConto);

        if(optional.isEmpty()){
            throw new RuntimeException("Il conto non esiste!");
        }

        ContoCorrente contoCancellato = optional.get();

        if(contoCancellato.getSaldo() != 0){
            throw new RuntimeException("Il saldo deve essere zero!");
        }

        contoCancellato.getMovimenti().clear();
        contoCancellato.getProprietari().clear();
        
        daoContoCorrente.deleteById(numeroConto);
    }

    @Override
    public String validitaConto(Integer numeroConto) {
        
        


        return null;
    }
}
