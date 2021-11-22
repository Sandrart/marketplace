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
import edu.es.eoi.service.PedidoServiceImpl;

@RestController
@RequestMapping(value = "/pedido")
public class PedidoController {
	
	@Autowired
	PedidoServiceImpl servicePedido;
	
	@PostMapping
	public ResponseEntity<String> createOne(@RequestBody PedidoDto dto) {
		
		servicePedido.save(dto);
		
		return new ResponseEntity<String>(HttpStatus.CREATED);
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> updateOne(@RequestBody PedidoDto dto, @PathVariable Integer id) {
		
		if(id.equals(dto.getId())&&servicePedido.find(id)!=null) {
			
			servicePedido.save(dto);
			
			return new ResponseEntity<String>(HttpStatus.ACCEPTED);
			
		}else {
			
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		
		}		
		
	}
	
	@GetMapping("/{id}")	
	public ResponseEntity<PedidoDto> getOne(@PathVariable Integer id) {

		return new ResponseEntity<PedidoDto>(servicePedido.find(id), HttpStatus.OK);
		
	}	
	
	@GetMapping("/{nombreParcial}")
	public ResponseEntity<List<PedidoDto>> getByNombre(@PathVariable String nombreParcial) {

		return new ResponseEntity<List<PedidoDto>>(servicePedido.findByNombre(nombreParcial), HttpStatus.OK);

	}
	
	@DeleteMapping("/{id}")	
	public ResponseEntity<String> deleteOne(@PathVariable Integer id) {

		servicePedido.delete(id);
		
		return new ResponseEntity<String>(HttpStatus.ACCEPTED);
		
	}

}
