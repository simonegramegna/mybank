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

    @Autowired
    private MovimentoDAO movimentoDAO;

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

        if(newSaldo < 0){
            throw new RuntimeException("Il nuovo saldo non può essere negativo!");
        }

        ContoCorrente cc = daoContoCorrente.findById(numeroConto).get();

        if(cc == null){
            throw new RuntimeException("Il conto corrente non esiste nel db!");
        }

        Utente operatore = daoUtente.findById(idUtenteOperatore).get();

        if(operatore == null){
            throw new RuntimeException("L'utente non esiste");
        }

        if(utilityConto.proprietarioCC(cc, idUtenteOperatore) == false){
            throw new RuntimeException("Proprietario e id utente non coincidono");
        }

        cc.setSaldo(newSaldo);

        Movimento movimento = new Movimento();

        movimento.setImporto(newSaldo);
        movimento.setOperatore(operatore);
        movimento.setTipo(TipoMovimento.VERSAMENTO);
        movimento.setDataOperazione(LocalDate.now());
        movimentoDAO.save(movimento);

        cc.addMovimento(movimento);
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
}
