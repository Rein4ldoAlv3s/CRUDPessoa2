package com.reinaldo.services;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reinaldo.domain.Pessoa;
import com.reinaldo.domain.dto.PessoaDTO;
import com.reinaldo.repositories.PessoaRepository;
import com.reinaldo.services.exceptions.ObjectNotFoundException;
import com.reinaldo.services.exceptions.DataIntegrityViolationException;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository repo;

	public Pessoa findByID(Integer id) {
		Optional<Pessoa> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! ID: " + id + " Tipo: " + Pessoa.class.getName()));
	}

	public Pessoa save(PessoaDTO objDTO) {
		if (findByCPF(objDTO) == null) {
			Pessoa obj = new Pessoa(null, objDTO.getNome(), objDTO.getCpf(), objDTO.getTelefone());
			return repo.save(obj);
		}
		throw new DataIntegrityViolationException(("O CPF já foi cadastrado. Informe outro"));
	}

	public Pessoa update(Integer id, PessoaDTO newDTO) {
		Pessoa oldObj = findByID(id);

		if (findByCPF(newDTO) != null && findByCPF(newDTO).getId() != id) {
			throw new DataIntegrityViolationException("Esse CPF já está cadastrado. Favor informar outro!");
		}

		oldObj.setCpf(newDTO.getCpf());
		oldObj.setNome(newDTO.getNome());
		oldObj.setTelefone(newDTO.getTelefone());
		return repo.save(oldObj);

	}

	public void delete(Integer id) {
		findByID(id);
		repo.deleteById(id);
	}

	private Pessoa findByCPF(PessoaDTO objDTO) {
		Pessoa obj = repo.findByCPF(objDTO.getCpf());
		if (obj != null) {
			return obj;
		}
		return null;
	}

}
