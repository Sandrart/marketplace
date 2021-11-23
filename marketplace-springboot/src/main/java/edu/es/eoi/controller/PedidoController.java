package edu.es.eoi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.es.eoi.dto.PedidoDto;

import edu.es.eoi.service.PedidoServiceImpl;

@Controller
@RequestMapping(value = "/pedido")
public class PedidoController {

	@Autowired
	PedidoServiceImpl service;
	
	
	//Crear un pedido
	@PostMapping
	public ResponseEntity <String> createOne(@RequestBody PedidoDto dto){
		
		service.save(dto);
		
		return new ResponseEntity<String>(HttpStatus.CREATED);
	}
	
	//Actualizar un pedido
	@PutMapping("/{id}")
	public ResponseEntity<String> updateOne(@RequestBody PedidoDto dto, @PathVariable Integer id){
		
		if(id.equals(dto.getId())&&service.findById(id)!=null) {
			
			service.save(dto);
			
			return new ResponseEntity<String>(HttpStatus.ACCEPTED);
		}else {
			
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PedidoDto> getOne(@PathVariable Integer id){
		
		return new ResponseEntity<PedidoDto>(service.findById(id), HttpStatus.OK);
		
	}
	
	//Falta el servicio para obtener los pedidos que contengan su atributo nombre, nombre parcial
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteOne(@PathVariable Integer id){
		
		service.delete(id);
		
		return new ResponseEntity<String>(HttpStatus.ACCEPTED);
	}
	
	
}
