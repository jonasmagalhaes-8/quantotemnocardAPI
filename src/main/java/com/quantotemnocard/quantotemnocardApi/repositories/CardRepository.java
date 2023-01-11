package com.quantotemnocard.quantotemnocardApi.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.quantotemnocard.quantotemnocardApi.models.CardModel;

@Repository
public interface CardRepository extends JpaRepository<CardModel, Integer> 
{
	@Query(value = "SELECT * FROM PUBLIC.tb_card where usuario_id = :userId order by id_Card", nativeQuery = true)
	public List<CardModel> getCardsByUser(@Param("userId") Integer userId);
	
	@Modifying
	@Query(value = "UPDATE PUBLIC.tb_card SET nome_card = :nomeCard WHERE id_card = :idCard;", nativeQuery = true)
	public Integer updateCardName(@Param("nomeCard") String nomeCard, @Param("idCard") Integer idCard);
}