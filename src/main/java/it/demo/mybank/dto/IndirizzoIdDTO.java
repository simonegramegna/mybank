package it.demo.mybank.dto;

public class IndirizzoIdDTO extends IndirizzoDTO{

    private Integer idIndirizzo;

    public IndirizzoIdDTO(){
        super();
    }

    public IndirizzoIdDTO(Integer id, String via, String cap, String citta, String provincia){
        super(via, cap, citta, provincia);
        this.idIndirizzo = id;
    }

    public Integer getIdIndirizzo() {
        return idIndirizzo;
    }

    public void setIdIndirizzo(Integer idIndirizzo) {
        this.idIndirizzo = idIndirizzo;
    }

    @Override
    public String toString() {
        return "IndirizzoIdDTO [idIndirizzo=" + idIndirizzo + ", getIdIndirizzo()=" + getIdIndirizzo() + ", getVia()="
                + getVia() + ", getCap()=" + getCap() + ", getCitta()=" + getCitta() + ", getProvincia()="
                + getProvincia() + "]";
    }
}
