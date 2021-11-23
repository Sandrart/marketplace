package edu.es.eoi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.es.eoi.dto.PedidoDto;
import edu.es.eoi.entity.Pedido;
import edu.es.eoi.repository.PedidoRepository;

@Service
public class PedidoServiceImpl {

	@Autowired
	PedidoRepository repo;
	
	public PedidoDto findById(Integer id) {
		
		Pedido pedido = repo.findById(id).get();
		
		PedidoDto dto = new PedidoDto();
		
		BeanUtils.copyProperties(pedido, dto);
		
		return dto;
	}
	
	//Obtener todos los pedidos que contengan en su
	//atributo nombre, nombreParcial
	
	//Crear un nuevo pedido
	public void save(PedidoDto dto) {
		
		Pedido entidad= new Pedido();
		BeanUtils.copyProperties(dto, entidad);
		
		repo.save(entidad);
	}
	
	//Eliminar un pedido por su id
	public void delete(Integer id) {
		
		repo.deleteById(id);
	}
}
