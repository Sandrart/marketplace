package edu.es.eoi.Service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.es.eoi.Dto.PedidoDto;
import edu.es.eoi.Entity.Pedido;
import edu.es.eoi.Repository.PedidoRepositorio;


@Service
public class PedidoServicio {
	
	
	@Autowired
	PedidoRepositorio repo;
	
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
