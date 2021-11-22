package edu.es.eoi.controller;

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
import edu.es.eoi.service.ArticuloServiceImpl;

@RestController
@RequestMapping(value = "/marketplace")
public class ArticuloController {

	@Autowired
	ArticuloServiceImpl service;
	
	@GetMapping("/articulo/{id}")
	public ResponseEntity<ArticuloDto> getOne(@PathVariable Integer id) {
		
		return new ResponseEntity<ArticuloDto>(service.find(id), HttpStatus.OK);
		
	}
	
	@PostMapping
	public ResponseEntity<String> createOne(@RequestBody ArticuloDto dto) {
		
		service.save(dto);
		
		return new ResponseEntity<String>(HttpStatus.CREATED);
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Integer> updateOne(@RequestBody ArticuloDto dto, @PathVariable Integer id) {
		
		if(id.equals(dto.getId())&&service.find(id)!=null) {
		
		service.save(dto);
		
		return new ResponseEntity<Integer>(HttpStatus.ACCEPTED);
		
		} else {
			
			return new ResponseEntity<Integer>(HttpStatus.BAD_REQUEST);
		}
	}
	
	
}
