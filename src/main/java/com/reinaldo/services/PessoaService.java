package com.reinaldo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.reinaldo.domain.Pessoa;
import com.reinaldo.domain.dto.PessoaDTO;
import com.reinaldo.repositories.PessoaRepository;
import com.reinaldo.services.exceptions.ObjectNotFoundException;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository repo;

	public Pessoa findByID(Integer id) {
		Optional<Pessoa> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! ID: " + 
				id + " Tipo: " + Pessoa.class.getName()));
	}

	public Pessoa save(PessoaDTO objDTO) {
		return repo.save(fromDTO(objDTO));
	}
	
	private Pessoa findByCPF(PessoaDTO objDTO) {
		Pessoa obj = repo.findByCPF(objDTO.getCpf());
		if(obj != null) {
			throw new DataIntegrityViolationException("Já existe cadastro com esse CPF. Informe outro.");
		} else {
			return obj;
		}
	}
	
	private Pessoa fromDTO(PessoaDTO objDTO) {
		Pessoa obj = new Pessoa();
		obj.setId(objDTO.getId());
		obj.setCpf(objDTO.getCpf());
		obj.setNome(objDTO.getNome());
		obj.setTelefone(objDTO.getTelefone());
		return obj;
	}
	
}
