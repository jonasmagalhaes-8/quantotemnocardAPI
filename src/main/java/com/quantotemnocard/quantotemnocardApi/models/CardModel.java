package com.quantotemnocard.quantotemnocardApi.models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_card")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class CardModel implements Serializable
{
	private static final long serialVersion = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "card_generator")
	@SequenceGenerator(name = "card_generator", sequenceName = "public.tb_card_seq", allocationSize = 1)
	private Integer idCard;
	
	private String nomeCard;
	
	private String ultimaRecarga;
	
	private String dataAlteracaoSaldo;
		
	private Double saldo;
		
	private Integer usuarioId;
	
	public CardModel()
	{
		
	}
	
	public CardModel(String nomeCard, String ultimaRecarga, String dataAlteracaoSaldo, Double saldo, Integer usuarioId)
	{
		this.nomeCard = nomeCard;
		this.ultimaRecarga = ultimaRecarga;
		this.dataAlteracaoSaldo = dataAlteracaoSaldo;
		this.saldo = saldo;
		this.usuarioId = usuarioId;
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

	public Integer getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Integer usuarioId) {
		this.usuarioId = usuarioId;
	}
}
