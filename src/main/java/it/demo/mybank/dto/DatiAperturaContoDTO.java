package it.demo.mybank.dto;

public class DatiAperturaContoDTO {

    private Double saldo;
	private Integer idProprietario;
	private Integer idCointestatario;
	
	public DatiAperturaContoDTO() {}
	
	public DatiAperturaContoDTO(Double saldo, Integer idProprietario, Integer idCointestatario) {
		this.saldo = saldo;
		this.idProprietario = idProprietario;
		this.idCointestatario = idCointestatario;
	}
	
	public Double getSaldo() {
		return saldo;
	}
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	public Integer getIdProprietario() {
		return idProprietario;
	}
	public void setIdProprietario(Integer idProprietario) {
		this.idProprietario = idProprietario;
	}
	public Integer getIdCointestatario() {
		return idCointestatario;
	}
	public void setIdCointestatario(Integer idCointestatario) {
		this.idCointestatario = idCointestatario;
	}
	@Override
	public String toString() {
		return "DatiAperturaContoDTO [saldo=" + saldo + ", idProprietario=" + idProprietario + ", idCointestatario="
				+ idCointestatario + "]";
	}
}
