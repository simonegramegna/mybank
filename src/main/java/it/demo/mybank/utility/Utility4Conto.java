package it.demo.mybank.utility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import it.demo.mybank.dto.ContoCorrenteDTO;
import it.demo.mybank.dto.MovimentoDTO;
import it.demo.mybank.entity.ContoCorrente;
import it.demo.mybank.entity.Movimento;
import it.demo.mybank.entity.Utente;

@Component
public class Utility4Conto {

    public ContoCorrenteDTO daContoCorrenteAContoCorrenteDTO(ContoCorrente cc) {

		if(cc == null){
            return null;
        } 
		
		ContoCorrenteDTO dto = new ContoCorrenteDTO();
		dto.setNumero(cc.getNumero());
		dto.setDataApertura(cc.getDataApertura());
		dto.setSaldo(cc.getSaldo());
		
		List<MovimentoDTO> lDto =
			cc.getMovimenti().stream()
							 .map( m -> daMovimentoAMovimentoDTO(m))
							 .collect(Collectors.toList());
		
		dto.setMovimenti(lDto);
		return dto;
	}
	
	public MovimentoDTO daMovimentoAMovimentoDTO(Movimento m) {
        
		if(m == null){
            return null;
        } 
		
		MovimentoDTO dto = new MovimentoDTO();
		dto.setIdMovimento(m.getIdMovimento());
		dto.setDataMovimento(m.getDataOperazione());
		dto.setImporto(m.getImporto());
		dto.setTipo(m.getTipo());
		dto.setIdOperatore(m.getOperatore().getIdUtente());
		
		return dto;
	}

	// controllo dato un cc e un id utente se lutente con l'id corrisponde ad un proprietario
	public boolean proprietarioCC(ContoCorrente cc, Integer idUtente){
		boolean result = false;
		
		for(Utente u : cc.getProprietari().values()){

			if(idUtente == u.getIdUtente()){
				result = true;
				break;
			}

		}
		return result;
	}

}
