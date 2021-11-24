package edu.es.eoi.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.es.eoi.dto.PedidoDto;
import edu.es.eoi.service.PedidoService;

@RestController
@RequestMapping(value = "/pedido")
public class PedidoController {

	
	@Autowired
	PedidoService service;
	
	
	
	@GetMapping("/nombre/{str}")
	public ResponseEntity<List<PedidoDto>> getByName(@PathVariable String str){
		
		return new ResponseEntity<List<PedidoDto>>(service.findByName(str), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<String> save(@RequestBody PedidoDto dto){
		
		service.save(dto);
		
		return new ResponseEntity<String>(HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> update(@RequestBody PedidoDto dto, @PathVariable Integer id){
		
		if(id.equals(dto.getId())) {
			
			service.update(dto);
			
			return new ResponseEntity<String>(HttpStatus.ACCEPTED);			
		} else {
			
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteOne(@PathVariable Integer id){
		
		service.delete(id);
		
		return new ResponseEntity<String>(HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PedidoDto> getOne(@PathVariable Integer id){
		
		return new ResponseEntity<PedidoDto>(service.find(id), HttpStatus.OK);
	}
}
