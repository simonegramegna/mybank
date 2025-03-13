package it.demo.mybank.dto;

public class UtenteDTO {

    private String nome;
	private String cognome;
	private String mail;
	private String telefono;
	
	public UtenteDTO() {}

	public UtenteDTO(String nome, String cognome, String mail, String telefono) {
		this.nome = nome;
		this.cognome = cognome;
		this.mail = mail;
		this.telefono = telefono;
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

	@Override
	public String toString() {
		return "UserDTO [nome=" + nome + ", cognome=" + cognome + ", mail=" + mail + ", telefono=" + telefono + "]";
	}

}
