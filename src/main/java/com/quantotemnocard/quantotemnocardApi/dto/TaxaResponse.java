package com.quantotemnocard.quantotemnocardApi.dto;

import com.quantotemnocard.quantotemnocardApi.models.TaxaModel;

public class TaxaResponse {

	private Integer idTaxa;
	
	private String nomeTaxa;
			
	private Double valor;
	
	public TaxaResponse() {
	}

	public TaxaResponse(TaxaModel taxaModel) {
		this.idTaxa = taxaModel.getIdTaxa();
		this.nomeTaxa = taxaModel.getNomeTaxa();
		this.valor = taxaModel.getValor();
	}

	public Integer getIdTaxa() {
		return idTaxa;
	}

	public void setIdTaxa(Integer idTaxa) {
		this.idTaxa = idTaxa;
	}

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
}
