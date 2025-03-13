package it.demo.mybank.utility;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import it.demo.mybank.config.AppConfig;
import it.demo.mybank.dto.ContoCorrenteDTO;
import it.demo.mybank.dto.MovimentoDTO;
import it.demo.mybank.entity.ContoCorrente;
import it.demo.mybank.entity.Movimento;

@Component
public class Utility4Conto {

    private final AppConfig appConfig;

    Utility4Conto(AppConfig appConfig) {
        this.appConfig = appConfig;
    }

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

}
