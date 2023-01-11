package com.quantotemnocard.quantotemnocardApi.services;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.quantotemnocard.quantotemnocardApi.dto.ResultResponse;
import com.quantotemnocard.quantotemnocardApi.dto.TaxaResponse;
import com.quantotemnocard.quantotemnocardApi.dto.TaxaInsertRequest;
import com.quantotemnocard.quantotemnocardApi.models.TaxaModel;
import com.quantotemnocard.quantotemnocardApi.repositories.TaxaRepository;

@Service
public class TaxaService
{
	@Autowired
	private TaxaRepository repository;
	
	@Transactional(readOnly = true)
	public List<TaxaResponse> getTaxasByUser(Integer usuarioId)
	{ 
		List<TaxaModel> taxas = repository.getTaxasByUser(usuarioId);
				
		return taxas.stream().map(x -> new TaxaResponse(x)).collect(Collectors.toList());
	}
	
	@Transactional
	public ResultResponse insert(TaxaInsertRequest model)
	{
		TaxaModel taxa = repository.save(new TaxaModel(model));
		
		ResultResponse sucesso = new ResultResponse(0);
		
		if(taxa!=null)
		sucesso.setResult(taxa.getIdTaxa());
		
		return sucesso;
	}

	@Transactional
	public ResultResponse update(TaxaModel updatedModel)
	{
		TaxaModel taxa = repository.save(updatedModel);
		
		ResultResponse sucesso = new ResultResponse(0);
		
		if(taxa!=null)
		sucesso.setResult(1);
		
		return sucesso;
	}

	public void delete(Integer id)
	{ repository.deleteById(id); }

}
