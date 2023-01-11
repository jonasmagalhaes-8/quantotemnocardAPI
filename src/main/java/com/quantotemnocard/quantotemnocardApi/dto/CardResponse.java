package com.quantotemnocard.quantotemnocardApi.dto;

import com.quantotemnocard.quantotemnocardApi.models.CardModel;

public class CardResponse
{
	private Integer idCard;
	
	private String nomeCard;
	
	private String ultimaRecarga;
	
	private String dataAlteracaoSaldo;
		
	private Double saldo;
		
	public CardResponse(CardModel cardModel) {
		this.idCard = cardModel.getIdCard();
		this.nomeCard = cardModel.getNomeCard();
		this.ultimaRecarga = cardModel.getUltimaRecarga();
		this.dataAlteracaoSaldo = cardModel.getDataAlteracaoSaldo();	
		this.saldo = cardModel.getSaldo();
	}

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

	public String getUltimaRecarga() {
		return ultimaRecarga;
	}

	public void setUltimaRecarga(String ultimaRecarga) {
		this.ultimaRecarga = ultimaRecarga;
	}

	public String getDataAlteracaoSaldo() {
		return dataAlteracaoSaldo;
	}

	public void setDataAlteracaoSaldo(String dataAlteracaoSaldo) {
		this.dataAlteracaoSaldo = dataAlteracaoSaldo;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
}
