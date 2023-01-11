package com.quantotemnocard.quantotemnocardApi.dto;

public class TelefoneRecuperaSenhaResponse {
	
	String telefone;
	String finalDigitosTelefone;
	
	public TelefoneRecuperaSenhaResponse()
	{}

	public TelefoneRecuperaSenhaResponse(String telefone, String finalDigitosTelefone) {
		this.telefone = telefone;
		this.finalDigitosTelefone = finalDigitosTelefone;
	}
	
	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getFinalDigitosTelefone() {
		return finalDigitosTelefone;
	}

	public void setFinalDigitosTelefone(String finalDigitosTelefone) {
		this.finalDigitosTelefone = finalDigitosTelefone;
	}	
}
