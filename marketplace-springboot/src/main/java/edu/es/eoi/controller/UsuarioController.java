package edu.es.eoi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.es.eoi.dto.UsuarioDto;
import edu.es.eoi.service.UsuarioServiceImpl;

@Controller
@RequestMapping(value = "/usuario")
public class UsuarioController {
	
	@Autowired
	UsuarioServiceImpl service;
	
	
	//Obtener los usuarios
	@GetMapping
	public ResponseEntity<List<UsuarioDto>> getAll(){
		
		return new ResponseEntity<List<UsuarioDto>>(service.findAll(), HttpStatus.OK);
	}
	
	//Crear un usuario
	@PostMapping
	public ResponseEntity<String> createOne(@RequestBody UsuarioDto dto){
		
		service.save(dto);
		
		return new ResponseEntity<String>(HttpStatus.CREATED);
	}
	
	@PostMapping("/login")
	public ResponseEntity<Boolean> login(@RequestBody UsuarioDto dto){
		return new ResponseEntity<Boolean>(service.existUser(dto), HttpStatus.OK); 
	}
	
	//Actualizar usuario
	@SuppressWarnings("unlikely-arg-type")
	@PutMapping("/{id}")
	public ResponseEntity<String> updateOne(@RequestBody UsuarioDto dto, @PathVariable Integer id){
		
		if(id.equals(dto.getId())&&service.findById(id)!=null) {
			
			service.save(dto);
			
			return new ResponseEntity<String>(HttpStatus.ACCEPTED);
		}else {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@GetMapping("/{id}")	
	public ResponseEntity<UsuarioDto> getOne(@PathVariable Integer id) {
		try {
			return new ResponseEntity<UsuarioDto>(service.findById(id), HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<UsuarioDto>(HttpStatus.NOT_FOUND);
		}
		
	}

}
