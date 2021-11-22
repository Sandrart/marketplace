package edu.es.eoi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.es.eoi.dto.UsuarioDto;
import edu.es.eoi.service.UsuarioServiceImpl;

@RestController
@RequestMapping(value = "/marketplace")
public class UsuarioController {

	@Autowired
	UsuarioServiceImpl service;
	
	@GetMapping("/usuario")
	public ResponseEntity<List<UsuarioDto>> getAll(){
		
		return new ResponseEntity<List<UsuarioDto>>(service.findAll(), HttpStatus.OK);
		
	}
	
	@PostMapping("/usuario")
	public ResponseEntity<String> createOne(@RequestBody UsuarioDto dto) {
		
		service.save(dto);
		
		return new ResponseEntity<String>(HttpStatus.CREATED);
		
	}
	
	@PutMapping("/usuario/{id}")
	public ResponseEntity<Integer> updateOne(@RequestBody UsuarioDto dto, @PathVariable Integer id) {
		
		if(id.equals(dto.getId())&&service.find(id)!=null) {
		
		service.save(dto);
		
		return new ResponseEntity<Integer>(HttpStatus.ACCEPTED);
		
		} else {
			
			return new ResponseEntity<Integer>(HttpStatus.BAD_REQUEST);
		}
	}
	
	
	
}
