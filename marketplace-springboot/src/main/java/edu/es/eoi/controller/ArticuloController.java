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

import edu.es.eoi.dto.ArticuloDto;
import edu.es.eoi.service.ArticuloServiceImpl;

@Controller
@RequestMapping(value = "/articulo")
public class ArticuloController {
	
	@Autowired
	ArticuloServiceImpl service;
	
	
	@GetMapping	
	public ResponseEntity<List<ArticuloDto>> getAll() {
		
		return new ResponseEntity<List<ArticuloDto>>(service.findAll(), HttpStatus.OK);
		
	}
	
	@PostMapping
	public ResponseEntity<String> createOne(@RequestBody ArticuloDto dto){
		
		service.save(dto);
		
		return new ResponseEntity<String>(HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> updateOne(@RequestBody ArticuloDto dto, @PathVariable Integer id){
		
		if(id.equals(dto.getId())&&service.find(id)!=null) {
			
			service.save(dto);
			return new ResponseEntity<String>(HttpStatus.ACCEPTED);
		}else {
			
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@GetMapping("/nombre/{nombreParcial}")
	public ResponseEntity<List<ArticuloDto>> getAllNombreParcial(@PathVariable String nombreParcial) {
		
		return new ResponseEntity<List<ArticuloDto>>(service.findAllNombreParcial(nombreParcial), HttpStatus.OK);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ArticuloDto> getOne(@PathVariable Integer id){
		
		return new ResponseEntity<ArticuloDto>(service.find(id), HttpStatus.OK);
	}
	
	//Obtener todos los articulos que contengan en su atributo nombre, nombre parcial
	
}
