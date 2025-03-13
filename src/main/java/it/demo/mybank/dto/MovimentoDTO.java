package it.demo.mybank.dto;

import java.time.LocalDate;
import it.demo.mybank.entity.TipoMovimento;

public class MovimentoDTO {
    
    private Integer idMovimento;
	private Double importo;
	private LocalDate dataMovimento;
	private TipoMovimento tipo;
	private Integer idOperatore;
	
	public MovimentoDTO() {}
	
	public MovimentoDTO(Integer idMovimento, Double importo, LocalDate dataMovimento, TipoMovimento tipo,
			Integer idOperatore) {
		this.idMovimento = idMovimento;
		this.importo = importo;
		this.dataMovimento = dataMovimento;
		this.tipo = tipo;
		this.idOperatore = idOperatore;
	}

	public Integer getIdMovimento() {
		return idMovimento;
	}

	public void setIdMovimento(Integer idMovimento) {
		this.idMovimento = idMovimento;
	}

	public Double getImporto() {
		return importo;
	}

	public void setImporto(Double importo) {
		this.importo = importo;
	}

	public LocalDate getDataMovimento() {
		return dataMovimento;
	}

	public void setDataMovimento(LocalDate dataMovimento) {
		this.dataMovimento = dataMovimento;
	}

	public TipoMovimento getTipo() {
		return tipo;
	}

	public void setTipo(TipoMovimento tipo) {
		this.tipo = tipo;
	}

	public Integer getIdOperatore() {
		return idOperatore;
	}

	public void setIdOperatore(Integer idOperatore) {
		this.idOperatore = idOperatore;
	}

	@Override
	public String toString() {
		return "MovimentoDTO [idMovimento=" + idMovimento + ", importo=" + importo + ", dataMovimento=" + dataMovimento
				+ ", tipo=" + tipo + ", idOperatore=" + idOperatore + "]";
	}
}
