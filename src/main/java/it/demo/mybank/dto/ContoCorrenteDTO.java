package it.demo.mybank.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ContoCorrenteDTO {

    private Integer numero;
	private Double saldo;
	private LocalDate dataApertura;
	
	private List<MovimentoDTO> movimenti = new ArrayList<>();

	public ContoCorrenteDTO() {}
	
	public ContoCorrenteDTO(Integer numero, Double saldo, LocalDate dataApertura) {
		this.numero = numero;
		this.saldo = saldo;
		this.dataApertura = dataApertura;
	}
	
	public void add(MovimentoDTO movDto) {
		this.movimenti.add(movDto);
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public LocalDate getDataApertura() {
		return dataApertura;
	}

	public void setDataApertura(LocalDate dataApertura) {
		this.dataApertura = dataApertura;
	}

	public List<MovimentoDTO> getMovimenti() {
		return movimenti;
	}

	public void setMovimenti(List<MovimentoDTO> movimenti) {
		this.movimenti = movimenti;
	}

	@Override
	public String toString() {
		return "ContoCorrenteDTO [numero=" + numero + ", saldo=" + saldo + ", dataApertura=" + dataApertura
				+ ", movimenti=" + movimenti + "]";
	}
}
