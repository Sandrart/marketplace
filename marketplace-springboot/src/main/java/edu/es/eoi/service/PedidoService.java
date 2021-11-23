package edu.es.eoi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.es.eoi.dto.ArticulosPedidoDto;
import edu.es.eoi.dto.PedidoDto;
import edu.es.eoi.entity.Pedido;
import edu.es.eoi.entity.PedidoArticulos;
import edu.es.eoi.repository.ArticuloRepository;
import edu.es.eoi.repository.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	PedidoRepository repo;
	
	@Autowired
	ArticuloRepository repoArt;
	
	public PedidoDto find(Integer id) {

		Pedido pedido= repo.findById(id).get();
		PedidoDto dto = new PedidoDto();

		dto.setFecha(pedido.getFecha());
		dto.setNombre(pedido.getNombre());
		dto.setId(pedido.getId());
		
		List<ArticulosPedidoDto> lista = new ArrayList<ArticulosPedidoDto>();
		
		for(PedidoArticulos pa: pedido.getPedidoArticulos()) {
			
			ArticulosPedidoDto temp = new ArticulosPedidoDto();
			temp.setId(pa.getArticulo().getId());
			temp.setCantidad(pa.getCantidad());
			
			lista.add(temp);
		}
		
		dto.setArticulos(lista);
		
		return dto;
	}
	
	public List<PedidoDto> findByName(String str){
		
		List<Pedido> pedidos = repo.findByNombreContaining(str);
		List<PedidoDto> lista = new ArrayList<PedidoDto>();
		
		for(Pedido pedido: pedidos) {
			
			PedidoDto dto = new PedidoDto();
			
			dto.setFecha(pedido.getFecha());
			dto.setId(pedido.getId());
			dto.setNombre(pedido.getNombre());
			
			List<ArticulosPedidoDto> listaArticulos = new ArrayList<ArticulosPedidoDto>();
			
			for(PedidoArticulos pa: pedido.getPedidoArticulos()) {
				
				ArticulosPedidoDto temp = new ArticulosPedidoDto();
				temp.setId(pa.getArticulo().getId());
				temp.setCantidad(pa.getCantidad());
				
				listaArticulos.add(temp);
			}
			
			dto.setArticulos(listaArticulos);
			
			lista.add(dto);
		}
		
		return lista;
	}
	

	public void save(PedidoDto dto) {

		Pedido pedido = new Pedido();
		
		List<PedidoArticulos> lista = new ArrayList<PedidoArticulos>();
		
		for (ArticulosPedidoDto temp : dto.getArticulos()) {
			
			PedidoArticulos pa = new PedidoArticulos();
			pa.setArticulo(repoArt.findById(temp.getId()).get());
			pa.setCantidad(temp.getCantidad());
			pa.setPedido(pedido);
			
			lista.add(pa);
		}
		
		pedido.setFecha(dto.getFecha());
		pedido.setNombre(dto.getNombre());
		pedido.setPedidoArticulos(lista);
		
		repo.save(pedido);
	}
	
	public void delete(Integer id) {
		
		repo.deleteById(id);
	}
}
