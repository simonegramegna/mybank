package it.demo.mybank.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

@Entity
public class ContoCorrente {
    
	@Id
    private int numero;

	private double saldo;
	private LocalDate dataApertura;
	
	@Transient
	private Map<Boolean, Utente> proprietari = new HashMap<Boolean, Utente>();

	@Transient
	private List<Movimento> movimenti = new ArrayList<Movimento>();
	
	public ContoCorrente() {}
	
	public ContoCorrente(int numero, double saldo, LocalDate dataApertura) {
		this.numero = numero;
		this.saldo = saldo;
		this.dataApertura = dataApertura;
	}
	
	public ContoCorrente(double saldo, LocalDate dataApertura) {
		this.saldo = saldo;
		this.dataApertura = dataApertura;
	}

	public void addProprietario(boolean b, Optional<Utente> utenteProprietario) {
		//this.proprietari.put(b, utenteProprietario);
	}
	
	public void removeProprietario() {
		if(this.proprietari.containsKey(false)){
			this.proprietari.remove(false);
		}
	}
	
	public void addMovimento(Movimento m) {
		this.movimenti.add(m);
	}
	public List<Movimento> getMovimenti() {
		return movimenti;
	}

	public void setMovimenti(List<Movimento> movimenti) {
		this.movimenti = movimenti;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public LocalDate getDataApertura() {
		return dataApertura;
	}

	public void setDataApertura(LocalDate dataApertura) {
		this.dataApertura = dataApertura;
	}

	public Map<Boolean, Utente> getProprietari() {
		return proprietari;
	}

	public void setProprietari(Map<Boolean, Utente> proprietari) {
		this.proprietari = proprietari;
	}

	@Override
	public String toString() {
		return "ContoCorrente [numero=" + numero + ", saldo=" + saldo + ", dataApertura=" + dataApertura
				+ ", proprietari=" + proprietari + ", movimenti=" + movimenti + "]";
	}

}
