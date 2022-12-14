package com.reinaldo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reinaldo.domain.Cidade;
import com.reinaldo.domain.dto.CidadeDTO;
import com.reinaldo.repositories.CidadeRepository;
import com.reinaldo.services.exceptions.ObjectNotFoundException;

@Service
public class CidadeService {

	@Autowired
	private CidadeRepository repo;
	
	public Cidade findByID(Integer id) {
		Optional<Cidade> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException
				("Objeto não encontrado! ID: " + id + " Tipo: " + Cidade.class));
	}
	
	public List<Cidade> findAll(){
		return repo.findAll();
	}

//	public Cidade save(CidadeDTO newDTO) {
//		
//		if(findByCidade(newDTO) != null) {
//			throw new DataIntegrityViolationException("Cidade já cadastrada, favor informar outra!");
//		}
//		
//		return repo.save(newDTO);
//	}
	
	public Cidade findByCidade(CidadeDTO obj) {
		Cidade otherObj = repo.findByCidade(obj.getNome());
		if(otherObj != null) {
			return otherObj;
		}
		return null;
	}
	
}
