package edu.es.eoi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.es.eoi.dto.ArticuloDto;
import edu.es.eoi.dto.PedidoArticuloDto;
import edu.es.eoi.dto.PedidoDto;
import edu.es.eoi.entity.Articulo;
import edu.es.eoi.entity.Pedido;
import edu.es.eoi.entity.PedidoArticulo;
import edu.es.eoi.repository.ArticuloRepository;
import edu.es.eoi.repository.PedidoRepository;

@Service
public class PedidoServiceImpl {

	@Autowired
	PedidoRepository repo;
	@Autowired
	ArticuloRepository articuloRepository;

	public PedidoDto findById(Integer id) {

		Pedido pedido = repo.findById(id).get();

		PedidoDto dto = new PedidoDto();

		BeanUtils.copyProperties(pedido, dto);

		return dto;
	}

	// Obtener todos los pedidos que contengan en su
	// atributo nombre, nombreParcial

	// Crear un nuevo pedido
	public void save(PedidoDto dto) {

		Pedido entidad = new Pedido();
		entidad.setFecha(dto.getFecha());
		entidad.setNombre(dto.getNombre());

		for (PedidoArticuloDto articulo : dto.getArticulos()) {

			Articulo a = articuloRepository.findById(articulo.getId()).get();
			a.getPedidos().add(entidad);
			entidad.getArticulos().add(a);
		}

		repo.save(entidad);
	}

	// Eliminar un pedido por su id
	public void delete(Integer id) {

		repo.deleteById(id);
	}

public List<PedidoDto> findByName(String str){
		
		List<Pedido> pedidos = repo.findByNombreContaining(str);
		List<PedidoDto> lista = new ArrayList<PedidoDto>();
		
		for(Pedido pedido: pedidos) {
			
			PedidoDto dto = new PedidoDto();
			
			dto.setFecha(pedido.getFecha());
			dto.setId(pedido.getId());
			dto.setNombre(pedido.getNombre());
			
			List<PedidoArticuloDto> listaArticulos = new ArrayList<PedidoArticuloDto>();
			
			for(PedidoArticuloDto pa: dto.getArticulos()) {
				
				PedidoArticuloDto temp = new PedidoArticuloDto();
				temp.setId(pa.getId());;
				temp.setCantidad(pa.getCantidad());
				
				listaArticulos.add(temp);
			}
			
			dto.setArticulos(listaArticulos);
			
			lista.add(dto);
		}
		
		return lista;
	}

}
