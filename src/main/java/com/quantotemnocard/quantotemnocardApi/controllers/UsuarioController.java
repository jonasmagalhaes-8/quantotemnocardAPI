package com.quantotemnocard.quantotemnocardApi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.quantotemnocard.quantotemnocardApi.dto.ResultResponse;
import com.quantotemnocard.quantotemnocardApi.dto.TelefoneRecuperaSenhaResponse;
import com.quantotemnocard.quantotemnocardApi.dto.UsuarioInsertUpdateRequest;
import com.quantotemnocard.quantotemnocardApi.dto.UsuarioLoginRequest;
import com.quantotemnocard.quantotemnocardApi.services.UsuarioService;

@RestController
@CrossOrigin
@RequestMapping(value = "/usuarios")
public class UsuarioController
{
	@Autowired
	private UsuarioService service;
	
	@PostMapping("/logar")
	public ResponseEntity<?> logar(@RequestBody UsuarioLoginRequest usuario)
	{ return ResponseEntity.ok().body(service.logar(usuario)); }
			
	@PostMapping
	public ResponseEntity<?> insert(@RequestBody UsuarioInsertUpdateRequest usuario)
	{ return ResponseEntity.ok().body(service.insert(usuario)); }
	
	@PutMapping("/updatesenha")
	public ResponseEntity<?> updateSenha(@RequestBody UsuarioInsertUpdateRequest usuario)
	{ return ResponseEntity.ok().body(service.updateSenha(usuario)); }
	
	@GetMapping(value = "/{email}")
	public ResponseEntity<?> getCardsByUser (@PathVariable String email)
	{ return ResponseEntity.ok().body(service.getTelefoneRecuperaSenha(email)); }
}