package com.reinaldo.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.reinaldo.domain.Pessoa;
import com.reinaldo.domain.dto.PessoaDTO;
import com.reinaldo.repositories.PessoaRepository;
import com.reinaldo.services.PessoaService;

@RestController
@RequestMapping("/pessoas")
public class PessoaResource {

	@Autowired
	private PessoaService service;
	@Autowired
	private PessoaRepository repo;

	@GetMapping("/{id}")
	public ResponseEntity<PessoaDTO> findByID(@PathVariable Integer id) {
		Pessoa obj = service.findByID(id);
		PessoaDTO objDTO = new PessoaDTO(obj);
		return ResponseEntity.ok().body(objDTO);
	}

	@GetMapping
	public ResponseEntity<List<PessoaDTO>> findAll() {
		List<Pessoa> list = repo.findAlll();
		List<PessoaDTO> listDTO = list.stream().map(obj -> new PessoaDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

	@PostMapping
	public ResponseEntity<PessoaDTO> save(@RequestBody @Valid PessoaDTO objDTO) {
		Pessoa obj = service.save(objDTO);
		PessoaDTO newObj = new PessoaDTO(obj);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<PessoaDTO> update(@PathVariable Integer id, @RequestBody @Valid PessoaDTO objDTO){
		Pessoa obj = service.update(id, objDTO);
		PessoaDTO newDto = new PessoaDTO(obj);
		return ResponseEntity.ok().body(newDto);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	
	
	
	
	
}
