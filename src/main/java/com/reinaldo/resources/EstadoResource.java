package com.reinaldo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reinaldo.domain.Estado;
import com.reinaldo.domain.dto.EstadoDTO;
import com.reinaldo.repositories.EstadoRepository;
import com.reinaldo.services.EstadoService;

@RestController
@RequestMapping("/estados")
public class EstadoResource {

	@Autowired
	private EstadoService service;
	@Autowired
	private EstadoRepository repo;
	
	@GetMapping("/{id}")
	public ResponseEntity<EstadoDTO> findByID(@PathVariable Integer id){
		Estado obj = service.findById(id);
		EstadoDTO objDTO = new EstadoDTO(obj);
		return ResponseEntity.ok().body(objDTO);
	}
	
	@GetMapping
	public ResponseEntity<List<Estado>> findAll(){
		return ResponseEntity.ok().body(repo.findAll());
	}
}
