package edu.es.eoi.marketplacespringboot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import javax.persistence.Entity;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mapping.context.PersistentEntities;
import org.springframework.stereotype.Service;

import edu.es.eoi.marketplacespringboot.dto.ArticuloDto;
import edu.es.eoi.marketplacespringboot.dto.PedidoDto;
import edu.es.eoi.marketplacespringboot.entity.Articulo;
import edu.es.eoi.marketplacespringboot.entity.Pedido;
import edu.es.eoi.marketplacespringboot.entity.PedidosArticulos;
import edu.es.eoi.marketplacespringboot.repository.ArticuloRepository;
import edu.es.eoi.marketplacespringboot.repository.PedidoRepository;
import edu.es.eoi.marketplacespringboot.repository.PedidosArticulosRepository;
import edu.es.eoi.marketplacespringboot.repository.UsuarioRepository;

@Service
public class PedidoServiceImpl {
	@Autowired
	PedidoRepository repoPedido;
	
	

	public void save(PedidoDto dto) {

		Pedido pedido = new Pedido();
		BeanUtils.copyProperties(dto, pedido);

		repoPedido.save(pedido);

	}

	public void delete(Integer id) {

		repoPedido.deleteById(id);

	}

	public PedidoDto find(Integer id) throws NoSuchElementException {		
		
		Pedido pedido = repoPedido.findById(id).get();

		PedidoDto dto = new PedidoDto();

		BeanUtils.copyProperties(pedido, dto);

		return dto;
	}

	public List<PedidoDto> findByNombre(String nombre) {

		List<Pedido> pedidos = repoPedido.findByNombreContaining(nombre);

		List<PedidoDto> lista = new ArrayList<PedidoDto>();

		for (Pedido pedido : pedidos) {
			List<ArticuloDto> listaArticulos = new ArrayList<ArticuloDto>();
			
			PedidoDto dto = new PedidoDto();
			dto.setNombre(pedido.getNombre());
			dto.setFecha(pedido.getFecha());
			
			for (PedidosArticulos temp : pedido.getPedidosArticulos()) {
				
				ArticuloDto dtoTemp = new ArticuloDto();
				dtoTemp.setPrecio(temp.getArticulo().getPrecio());
				dtoTemp.setNombre(temp.getArticulo().getNombre());
				dtoTemp.setStock(temp.getArticulo().getStock());
				listaArticulos.add(dtoTemp);
			}
			
			List<Articulo> articulos =  new ArrayList<Articulo>();
			
			BeanUtils.copyProperties(listaArticulos, articulos);
			
			dto.setArticulos(articulos);

			lista.add(dto);

		}
		return lista;

	}
	
}
