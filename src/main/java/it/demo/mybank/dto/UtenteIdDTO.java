package it.demo.mybank.dto;

public class UtenteIdDTO extends UtenteDTO {

    private Integer idUtente;

	public UtenteIdDTO() {}
	
	public UtenteIdDTO(Integer idUtente, String nome, String cognome, String mail, String telefono, IndirizzoDTO indirizzoDTO) {
		super(nome, cognome, mail, telefono, indirizzoDTO);
		this.idUtente = idUtente;
	}

	public Integer getIdUtente() {
		return idUtente;
	}

	public void setIdUtente(Integer idUtente) {
		this.idUtente = idUtente;
	}

	@Override
	public String toString() {
		return "UserDTOConId [idUtente=" + idUtente + ", toString()=" + super.toString() + "]";
	}
}
