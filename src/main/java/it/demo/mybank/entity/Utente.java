package it.demo.mybank.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="utente")
public class Utente {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUtente;

	private String nome; 
	private String cognome;
	private String mail;
	private String telefono;
	
	@Embedded
	private Indirizzo residenza;
	
	public Utente() {}
			
	public Utente(int idUtente, String nome, String cognome, String mail, String telefono) {
		this.idUtente = idUtente;
		this.nome = nome;
		this.cognome = cognome;
		this.mail = mail;
		this.telefono = telefono;
	}
	
	public Indirizzo getResidenza() {
		return residenza;
	}

	public void setResidenza(Indirizzo residenza) {
		this.residenza = residenza;
	}

	public int getIdUtente() {
		return idUtente;
	}

	public void setIdUtente(int idUtente) {
		this.idUtente = idUtente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	

	@Override
	public String toString() {
		return "Utente [idUtente=" + idUtente + ", nome=" + nome + ", cognome=" + cognome + ", mail=" + mail
				+ ", telefono=" + telefono + ", residenza=" + residenza + "]";
	}
}
