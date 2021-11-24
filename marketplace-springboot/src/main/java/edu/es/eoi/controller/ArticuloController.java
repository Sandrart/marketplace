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

import edu.es.eoi.dto.ArticuloDto;
import edu.es.eoi.service.ArticuloService;

@RestController
@RequestMapping(value = "/articulo")
public class ArticuloController {

	
	@Autowired
	ArticuloService service;
	
	
	
	@GetMapping("/nombre/{str}")
	public ResponseEntity<List<ArticuloDto>> getByName(@PathVariable String str){
		
		return new ResponseEntity<List<ArticuloDto>>(service.findByName(str), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<String> save(@RequestBody ArticuloDto dto){
		
		service.save(dto);
		
		return new ResponseEntity<String>(HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> update(@RequestBody ArticuloDto dto, @PathVariable Integer id){
		
		if(id.equals(dto.getId()) && service.find(id) != null) {
			
			service.save(dto);
			
			return new ResponseEntity<String>(HttpStatus.ACCEPTED);			
		} else {
			
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ArticuloDto> getOne(@PathVariable Integer id){
		
		return new ResponseEntity<ArticuloDto>(service.find(id), HttpStatus.OK);
	}
}
