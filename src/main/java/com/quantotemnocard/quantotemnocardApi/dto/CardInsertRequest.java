package com.quantotemnocard.quantotemnocardApi.dto;

public class CardInsertRequest
{
	private String nomeCard;
	
	private Integer usuarioId;
		
	public String getNomeCard() {
		return nomeCard;
	}

	public void setNomeCard(String nomeCard) {
		this.nomeCard = nomeCard;
	}

	public Integer getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Integer usuarioId) {
		this.usuarioId = usuarioId;
	}	
}
