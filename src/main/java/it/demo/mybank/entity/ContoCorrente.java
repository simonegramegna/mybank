package it.demo.mybank.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class ContoCorrente {
    
	@Id
	@Column(name="id_conto_corrente")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int numero;

	private double saldo;
	private LocalDate dataApertura;
	
	@ManyToMany
	@JoinTable(name = "proprietari_conto", joinColumns = @JoinColumn(name="fk_conto"), inverseJoinColumns = @JoinColumn(name="fk_utente"))
	private Map<Boolean, Utente> proprietari = new HashMap<Boolean, Utente>();

	@ManyToMany
	@JoinTable(name = "movimenti_conto", joinColumns =  @JoinColumn(name="fk_conto"), inverseJoinColumns = @JoinColumn(name="fk_movimenti"))
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

	public void addProprietario(boolean b, Utente utenteProprietario) {
		this.proprietari.put(b, utenteProprietario);
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
