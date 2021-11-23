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
import edu.es.eoi.service.UsuarioService;

@RestController
@RequestMapping(value = "/marketplace/usuario")
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
		
		return new ResponseEntity<String>(HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> update(@RequestBody UsuarioDto dto, @PathVariable Integer id){
		
		if(id.equals(dto.getId()) && service.find(id) != null) {
			
			service.save(dto);
			
			return new ResponseEntity<String>(HttpStatus.ACCEPTED);			
		} else {
			
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}
	
	
	@PostMapping("/login")
	public ResponseEntity<Boolean> userLogin(@RequestBody UsuarioDto dto){
		
		return new ResponseEntity<Boolean>(service.checkUser(dto), HttpStatus.OK);
	}
}




