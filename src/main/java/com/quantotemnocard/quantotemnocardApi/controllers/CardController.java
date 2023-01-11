package com.quantotemnocard.quantotemnocardApi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quantotemnocard.quantotemnocardApi.dto.CardInsertRequest;
import com.quantotemnocard.quantotemnocardApi.dto.CardNameUpdateRequest;
import com.quantotemnocard.quantotemnocardApi.models.CardModel;
import com.quantotemnocard.quantotemnocardApi.services.CardService;

@RestController
@CrossOrigin
@RequestMapping(value = "/cards")
public class CardController {

	@Autowired
	private CardService service;
				
	@PostMapping
	public ResponseEntity<?> insert(@RequestBody CardInsertRequest card) {
		return ResponseEntity.ok().body(service.insert(card));
	}
	
	@PutMapping
	public ResponseEntity<?> update(@RequestBody CardModel dto) {
		return ResponseEntity.ok().body(service.update(dto));
	}
	
	@PutMapping(value = "/updateNomeCard")
	public ResponseEntity<?> updateNomeCard(@RequestBody CardNameUpdateRequest dto) {
		return ResponseEntity.ok().body(service.updateNomeCard(dto));
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) { 
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping(value = "/{iduser}")
	public ResponseEntity<?> getCardsByUser (@PathVariable Integer iduser) { 
		return ResponseEntity.ok().body(service.getCardsByUser(iduser));
	}
}