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
public class PedidoService {

	@Autowired
	PedidoRepository repo;
	
	public PedidoDto find(Integer id) {

		Pedido pedido= repo.findById(id).get();
		PedidoDto dto = new PedidoDto();

		BeanUtils.copyProperties(pedido, dto);

		return dto;
	}
	
	public List<PedidoDto> findByName(String str){
		
		List<Pedido> pedidos = repo.findByNombreContaining(str);
		List<PedidoDto> lista = new ArrayList<PedidoDto>();
		
		for(Pedido pedido: pedidos) {
			PedidoDto dto = new PedidoDto();
			BeanUtils.copyProperties(pedido, dto);
			
			lista.add(dto);
		}
		
		return lista;
	}
}
