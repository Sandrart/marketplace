package edu.es.eoi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.es.eoi.dto.UsuarioDto;
import edu.es.eoi.service.UsuarioService;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {

	@Autowired
	UsuarioService service;
	
	@GetMapping
	public ResponseEntity<List<UsuarioDto>> getAll(){
		
		return new ResponseEntity<List<UsuarioDto>>(service.findAll(), HttpStatus.ACCEPTED);
	}
	
	@PostMapping
	public ResponseEntity<String> save(@RequestBody UsuarioDto dto){
		
		service.save(dto);
		
		return new ResponseEntity<String>(HttpStatus.ACCEPTED);
	}
}


