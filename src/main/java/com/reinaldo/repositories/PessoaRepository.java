package com.reinaldo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.reinaldo.domain.Pessoa;
import com.reinaldo.domain.dto.PessoaDTO;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer>{

	@Query("SELECT obj FROM Pessoa obj")
	List<Pessoa> findAlll();

	@Query("SELECT obj FROM Pessoa obj WHERE obj.cpf =:cpf")
	Pessoa findByCPF(@Param("cpf") String cpf);

}
