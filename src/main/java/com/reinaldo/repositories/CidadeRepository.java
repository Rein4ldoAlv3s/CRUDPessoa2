package com.reinaldo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.reinaldo.domain.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Integer>{

	@Query("SELECT obj FROM Cidade obj")
	List<Cidade> findAlll();

	@Query("SELECT obj FROM Cidade obj WHERE nome =:nome")
	Cidade findByCidade(@Param("nome") String nome);
	
	
	
}
