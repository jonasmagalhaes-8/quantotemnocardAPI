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
import com.quantotemnocard.quantotemnocardApi.dto.TaxaInsertRequest;
import com.quantotemnocard.quantotemnocardApi.models.TaxaModel;
import com.quantotemnocard.quantotemnocardApi.services.TaxaService;

@RestController
@CrossOrigin
@RequestMapping(value = "/taxas")
public class TaxaController {

	@Autowired
	private TaxaService service;
				
	@PostMapping
	public ResponseEntity<?> insert(@RequestBody TaxaInsertRequest taxa)
	{ return ResponseEntity.ok().body(service.insert(taxa)); }
	
	@PutMapping
	public ResponseEntity<?> update(@RequestBody TaxaModel dto)
	{ return ResponseEntity.ok().body(service.update(dto)); }
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id)
	{ 
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping(value = "/{iduser}")
	public ResponseEntity<?> getTaxasByUser (@PathVariable Integer iduser)
	{ return ResponseEntity.ok().body(service.getTaxasByUser(iduser)); }
	
}
