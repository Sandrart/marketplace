package edu.es.eoi.marketplacespringboot.controller;

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

import edu.es.eoi.marketplacespringboot.dto.ArticuloDto;
import edu.es.eoi.marketplacespringboot.service.ArticuloServiceImpl;

@RestController
@RequestMapping(value = "marketplace/articulo")
public class ArticuloController {
	@Autowired
	ArticuloServiceImpl serviceArticulo;
	
	@GetMapping	
	public ResponseEntity<List<ArticuloDto>> getAll() {
		
		return new ResponseEntity<List<ArticuloDto>>(serviceArticulo.findAll(), HttpStatus.OK);
		
	}
	
	@PostMapping
	public ResponseEntity<String> createOne(@RequestBody ArticuloDto dto) {
		if(!serviceArticulo.existeArticulo(dto)) {
			serviceArticulo.save(dto);
			return new ResponseEntity<String>(HttpStatus.CREATED);
		}else {
			return new ResponseEntity<String>(HttpStatus.NOT_ACCEPTABLE);
		}
	}	
	@GetMapping("/{id}")	
	public ResponseEntity<ArticuloDto> getOne(@PathVariable Integer id) {
		try {
			return new ResponseEntity<ArticuloDto>(serviceArticulo.find(id), HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<ArticuloDto>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@GetMapping("/{nombreParcial}")
	public ResponseEntity<List<ArticuloDto>> getAllNombreParcial(@PathVariable String nombreParcial) {
		
		return new ResponseEntity<List<ArticuloDto>>(serviceArticulo.findAllNombreParcial(nombreParcial), HttpStatus.OK);
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> updateOne(@RequestBody ArticuloDto dto, @PathVariable Integer id) {
		if(id.equals(dto.getId())&&serviceArticulo.find(id)!=null) {
			
			serviceArticulo.save(dto);
			
			return new ResponseEntity<String>(HttpStatus.ACCEPTED);
			
		}else {
			
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		
		}		
		
	}
	
	
	
}
