package com.reinaldo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.reinaldo.domain.Estado;

public interface EstadoRepository extends JpaRepository<Estado, Integer>{

	@Query("SELECT obj FROM Estado obj")
	List<Estado> findAlll();
}
