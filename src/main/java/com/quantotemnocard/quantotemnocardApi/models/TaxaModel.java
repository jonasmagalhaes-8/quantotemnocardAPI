package com.quantotemnocard.quantotemnocardApi.models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.quantotemnocard.quantotemnocardApi.dto.TaxaInsertRequest;

@Entity
@Table(name = "tb_taxa")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class TaxaModel implements Serializable
{
	private static final long serialVersion = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "taxa_generator")
	@SequenceGenerator(name = "taxa_generator", sequenceName = "public.tb_taxa_seq", allocationSize = 1)
	private Integer idTaxa;
	
	private String nomeTaxa;
			
	private Double valor;

	private Integer usuarioId;
		
	public TaxaModel() {
	}

	public TaxaModel(TaxaInsertRequest taxaInsertDTO) {
		this.nomeTaxa = taxaInsertDTO.getNomeTaxa();
		this.valor = taxaInsertDTO.getValor();
		this.usuarioId = taxaInsertDTO.getUsuarioId();
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

	public Integer getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Integer usuarioId) {
		this.usuarioId = usuarioId;
	}	
}
