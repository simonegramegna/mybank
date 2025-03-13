package it.demo.mybank.entity;

import java.time.LocalDate;

public class Movimento {
    
    private int idMovimento;
	private TipoMovimento tipo;
	private double importo;
	private LocalDate dataOperazione;
	private Utente operatore;
	
	public Movimento() {}
	
	public Movimento(int idMovimento, TipoMovimento tipo, double importo, LocalDate dataOperazione, Utente operatore) {
		this.idMovimento = idMovimento;
		this.tipo = tipo;
		this.importo = importo;
		this.dataOperazione = dataOperazione;
		this.operatore = operatore;
	}
	
	public int getIdMovimento() {
		return idMovimento;
	}
	public void setIdMovimento(int idMovimento) {
		this.idMovimento = idMovimento;
	}
	public TipoMovimento getTipo() {
		return tipo;
	}
	public void setTipo(TipoMovimento tipo) {
		this.tipo = tipo;
	}
	public double getImporto() {
		return importo;
	}
	public void setImporto(double importo) {
		this.importo = importo;
	}
	public LocalDate getDataOperazione() {
		return dataOperazione;
	}
	public void setDataOperazione(LocalDate dataOperazione) {
		this.dataOperazione = dataOperazione;
	}
	public Utente getOperatore() {
		return operatore;
	}
	public void setOperatore(Utente operatore) {
		this.operatore = operatore;
	}

}
