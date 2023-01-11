package com.quantotemnocard.quantotemnocardApi.dto;

public class CardNameUpdateRequest {

	private Integer idCard;
	private String nomeCard;
	
	public Integer getIdCard() {
		return idCard;
	}
	public void setIdCard(Integer idCard) {
		this.idCard = idCard;
	}
	public String getNomeCard() {
		return nomeCard;
	}
	public void setNomeCard(String nomeCard) {
		this.nomeCard = nomeCard;
	}
}
