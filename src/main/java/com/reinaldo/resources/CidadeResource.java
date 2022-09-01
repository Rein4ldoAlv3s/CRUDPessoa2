package com.reinaldo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reinaldo.domain.Cidade;
import com.reinaldo.domain.dto.CidadeDTO;
import com.reinaldo.services.CidadeService;

@RestController
@RequestMapping("/cidades")
public class CidadeResource {

	@Autowired
	private CidadeService service;
	
	//Retorna a lista de apenas cidades
	@GetMapping
	public ResponseEntity<List<CidadeDTO>> findAll(){
		List<CidadeDTO> objDTO = service.findAll().stream().map(obj -> new CidadeDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(objDTO);
	}
	
	//Retorna Cidade vinculado com Estado
	@GetMapping("/{id}")
	public ResponseEntity<Cidade> findByID(@PathVariable Integer id){
		Cidade obj = service.findByID(id);
		return ResponseEntity.ok().body(obj);
	}
	
//	@PostMapping
//	public ResponseEntity<CidadeDTO> save(@RequestBody CidadeDTO objDTO){
//		
//		service.save(objDTO);
//	}
	
	
}
