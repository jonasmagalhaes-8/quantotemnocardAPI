package com.quantotemnocard.quantotemnocardApi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.quantotemnocard.quantotemnocardApi.dto.ResultResponse;
import com.quantotemnocard.quantotemnocardApi.dto.TelefoneRecuperaSenhaResponse;
import com.quantotemnocard.quantotemnocardApi.dto.UsuarioInsertUpdateRequest;
import com.quantotemnocard.quantotemnocardApi.dto.UsuarioLoginRequest;
import com.quantotemnocard.quantotemnocardApi.models.UsuarioModel;
import com.quantotemnocard.quantotemnocardApi.repositories.UsuarioRepository;

@Service
public class UsuarioService
{
	@Autowired
	private UsuarioRepository repository;
		
	@Transactional
	public ResultResponse insert(UsuarioInsertUpdateRequest usuarioInsertDTO)
	{
		ResultResponse usuarioId = new ResultResponse(0);
		
		if(repository.findByEmail(usuarioInsertDTO.getEmail())==null && repository.findByTelefone(usuarioInsertDTO.getTelefone())==null)
		usuarioId.setResult(repository.save(new UsuarioModel(usuarioInsertDTO)).getUsuarioId());
		
		return usuarioId;
	}

	@Transactional(readOnly = true)
	public ResultResponse logar(UsuarioLoginRequest usuarioLoginDTO)
	{
		ResultResponse usuarioId = new ResultResponse(0);
	
		UsuarioModel usuario = repository.logar(usuarioLoginDTO.getEmail(), usuarioLoginDTO.getSenha());
			
		if(usuario!=null)
		usuarioId.setResult(usuario.getUsuarioId());
		
		return usuarioId;
	}
	
	@Transactional
	public TelefoneRecuperaSenhaResponse getTelefoneRecuperaSenha(String email)
	{
		UsuarioModel model = repository.getTelefoneRecuperacaoSenha(email);
							
		TelefoneRecuperaSenhaResponse recoverResult = new TelefoneRecuperaSenhaResponse();
		
		if(model!=null) {
			recoverResult.setTelefone(model.getTelefone());
			recoverResult.setFinalDigitosTelefone(model.getTelefone().substring(7));
		}
		
		return recoverResult;
	}
	
	@Transactional
	public ResultResponse updateSenha(UsuarioInsertUpdateRequest usuarioUpdateDTO) {
		return new ResultResponse(repository.novaSenha(usuarioUpdateDTO.getSenha() , usuarioUpdateDTO.getEmail(), usuarioUpdateDTO.getTelefone()));
	}
}