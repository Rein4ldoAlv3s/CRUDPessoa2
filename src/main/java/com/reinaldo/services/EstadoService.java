package com.reinaldo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reinaldo.domain.Estado;
import com.reinaldo.repositories.EstadoRepository;
import com.reinaldo.services.exceptions.ObjectNotFoundException;

@Service
public class EstadoService {

	@Autowired
	private EstadoRepository repo;
	
	public Estado findById(Integer id) {
		Optional<Estado> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException
				("Estado não encontrado! ID: " + id + " Classe: " + Estado.class ));
	}
	
	public List<Estado> findAll(){
		return repo.findAll();
	}
}
