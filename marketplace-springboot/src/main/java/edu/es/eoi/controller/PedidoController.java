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
@RequestMapping(value = "/marketplace")
public class PedidoController {

	@Autowired
	PedidoServiceImpl service;

	@GetMapping("/pedido/{id}")
	public ResponseEntity<PedidoDto> getOne(@PathVariable Integer id) {

		return new ResponseEntity<PedidoDto>(service.find(id), HttpStatus.OK);

	}

	@PostMapping("/pedido")
	public ResponseEntity<String> createOne(@RequestBody PedidoDto dto) {

		service.save(dto);

		return new ResponseEntity<String>(HttpStatus.CREATED);

	}

	@PutMapping("/pedido/{id}")
	public ResponseEntity<Integer> updateOne(@RequestBody PedidoDto dto, @PathVariable Integer id) {
		if (id.equals(dto.getId()) && service.find(id) != null) {

			service.save(dto);
			return new ResponseEntity<Integer>(HttpStatus.ACCEPTED);

		} else {

			return new ResponseEntity<Integer>(HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/pedido/{id}")
	public ResponseEntity<Integer> deleteOne(@PathVariable Integer id) {

		service.delete(id);

		return new ResponseEntity<Integer>(HttpStatus.ACCEPTED);

	}

	@GetMapping("/pedido/nombre/{nombreparcial}")
	public ResponseEntity<List<PedidoDto>> nombreContenido(@PathVariable String nombreParcial) {
		return new ResponseEntity<List<PedidoDto>>(service.nombreParcial(nombreParcial), HttpStatus.ACCEPTED);
	}

}
