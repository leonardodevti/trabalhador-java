package entidades;

import java.util.Date;

public class ContratoPorHora {

	private Date data;
	private Double valorPorHora;
	private Integer horas;

	public ContratoPorHora () {
	
	}

	public ContratoPorHora(Date data, Double valorPorHora, Integer hora) {
		this.data = data;
		this.valorPorHora = valorPorHora;
		this.horas = hora;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Double getValorPorHora() {
		return valorPorHora;
	}

	public void setValorPorHora(Double valorPorHora) {
		this.valorPorHora = valorPorHora;
	}

	public Integer getHora() {
		return horas;
	}

	public void setHora(Integer hora) {
		this.horas = hora;
	}
	
	public double valorTotal () {
		return valorPorHora * horas;
	}
}
