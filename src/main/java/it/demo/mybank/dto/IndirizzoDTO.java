package it.demo.mybank.dto;

public class IndirizzoDTO {
    private String via;
    private String cap;
    private String citta;
    private String provincia;

    public IndirizzoDTO() {
    }

    public IndirizzoDTO(String via, String cap, String citta, String provincia) {
        this.via = via;
        this.cap = cap;
        this.citta = citta;
        this.provincia = provincia;
    }

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public String getCap() {
        return cap;
    }

    public void setCap(String cap) {
        this.cap = cap;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    @Override
    public String toString() {
        return "IndirizzoDTO [via=" + via + ", cap=" + cap + ", citta=" + citta + ", provincia=" + provincia + "]";
    }
}
