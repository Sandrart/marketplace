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
	
	public PedidoDto find(Integer id) {
		
		Pedido p = repo.findById(id).get();
		
		PedidoDto dto = new PedidoDto();
		
		BeanUtils.copyProperties(p, dto);
		
		return dto;
	}
	
	public List<PedidoDto> findAll(){
		
		List<Pedido> pedidos = repo.findAll();
		List<PedidoDto> lista = new ArrayList<PedidoDto>();
		
		for (Pedido pedido : pedidos) {
			PedidoDto dto = new PedidoDto();
			BeanUtils.copyProperties(pedido, dto);
			
			lista.add(dto);
		}
		
		return lista;
	}
	
	public void save(PedidoDto dto) {
		
		Pedido entity = new Pedido();
		BeanUtils.copyProperties(dto, entity);

		repo.save(entity);
	}
	
	public void delete(Integer id) {
		
		repo.deleteById(id);
	}
	
	public void deleteAll() {
		
		repo.deleteAll();
	}
}
