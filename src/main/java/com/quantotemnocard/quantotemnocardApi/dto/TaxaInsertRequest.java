package com.quantotemnocard.quantotemnocardApi.dto;

public class TaxaInsertRequest {

	private String nomeTaxa;
	
	private Double valor;

	private Integer usuarioId;

	public String getNomeTaxa() {
		return nomeTaxa;
	}

	public void setNomeTaxa(String nomeTaxa) {
		this.nomeTaxa = nomeTaxa;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Integer getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Integer usuarioId) {
		this.usuarioId = usuarioId;
	}	
}
