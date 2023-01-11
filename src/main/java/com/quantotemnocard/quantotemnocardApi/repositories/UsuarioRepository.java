package com.quantotemnocard.quantotemnocardApi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.quantotemnocard.quantotemnocardApi.models.UsuarioModel;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Integer>
{
	UsuarioModel findByEmail(String email);
	
	UsuarioModel findByTelefone(String telefone);
	
	@Query(value = "SELECT * FROM PUBLIC.tb_usuario where email = :userEmail and senha = :userSenha", nativeQuery = true)
	UsuarioModel logar(String userEmail, String userSenha);
	
	@Modifying
	@Query(value = "UPDATE PUBLIC.tb_usuario SET senha = :novaSenha WHERE email = :userEmail and telefone = :userTelefone", nativeQuery = true)
	int novaSenha(String novaSenha, String userEmail, String userTelefone);
	
	@Query(value = "SELECT * FROM PUBLIC.tb_usuario where email = :userEmail", nativeQuery = true)
	UsuarioModel getTelefoneRecuperacaoSenha(String userEmail);
}