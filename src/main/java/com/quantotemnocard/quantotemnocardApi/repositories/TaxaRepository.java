package com.quantotemnocard.quantotemnocardApi.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.quantotemnocard.quantotemnocardApi.models.TaxaModel;

@Repository
public interface TaxaRepository extends JpaRepository<TaxaModel, Integer> {

	@Query(value = "SELECT * FROM PUBLIC.tb_taxa where usuario_id = :userId order by id_Taxa", nativeQuery = true)
	public List<TaxaModel> getTaxasByUser(@Param("userId") Integer userId);
	
}
