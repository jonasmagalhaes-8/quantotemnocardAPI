package com.quantotemnocard.quantotemnocardApi.services;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.quantotemnocard.quantotemnocardApi.dto.CardResponse;
import com.quantotemnocard.quantotemnocardApi.dto.CardInsertRequest;
import com.quantotemnocard.quantotemnocardApi.dto.CardNameUpdateRequest;
import com.quantotemnocard.quantotemnocardApi.dto.ResultResponse;
import com.quantotemnocard.quantotemnocardApi.models.CardModel;
import com.quantotemnocard.quantotemnocardApi.repositories.CardRepository;

@Service
public class CardService
{
	@Autowired
	private CardRepository repository;
	
	@Transactional(readOnly = true)
	public List<CardResponse> getCardsByUser(Integer usuarioId)
	{ 
		List<CardModel> cards = repository.getCardsByUser(usuarioId);
				
		return cards.stream().map(x -> new CardResponse(x)).collect(Collectors.toList());
	}
	
	@Transactional
	public ResultResponse insert(CardInsertRequest model)
	{
		CardModel card = repository.save(new CardModel(model.getNomeCard(),
		"Sem registro",
		"Sem registro",
		0.0,
		model.getUsuarioId()));
		
		ResultResponse sucesso = new ResultResponse(0);
		
		if(card!=null)
		sucesso.setResult(card.getIdCard());
		
		return sucesso;
	}

	@Transactional
	public ResultResponse updateNomeCard(CardNameUpdateRequest updateNameDTO) {
		return new ResultResponse(repository.updateCardName(updateNameDTO.getNomeCard(), updateNameDTO.getIdCard()));
	}
	
	@Transactional
	public ResultResponse update(CardModel updatedModel)
	{
		
		CardModel card = repository.getReferenceById(updatedModel.getIdCard());
		
		BeanUtils.copyProperties(updatedModel, card, "id");
				
		card = repository.save(card);
				
		ResultResponse sucesso = new ResultResponse(0);
		
		if(card!=null)
		sucesso.setResult(1);
		
		return sucesso;
	}

	public void delete(Integer id)
	{ repository.deleteById(id); }
}