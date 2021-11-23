package edu.es.eoi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.es.eoi.dto.ArticuloDto;
import edu.es.eoi.dto.PedidoDto;
import edu.es.eoi.entity.Pedido;
import edu.es.eoi.entity.PedidoArticulo;
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

	// Obtener todos los pedidos que contengan en su
	// atributo nombre, nombreParcial

	// Crear un nuevo pedido
	public void save(PedidoDto dto) {

		Pedido entidad = new Pedido();
		BeanUtils.copyProperties(dto, entidad);

		repo.save(entidad);
	}

	// Eliminar un pedido por su id
	public void delete(Integer id) {

		repo.deleteById(id);
	}

	public List<PedidoDto> findByNombre(String nombre) {

		List<Pedido> pedidos = repo.findByNombreContaining(nombre);

		List<PedidoDto> lista = new ArrayList<PedidoDto>();

		for (Pedido pedido : pedidos) {
			List<ArticuloDto> listaArticulos = new ArrayList<ArticuloDto>();

			PedidoDto dto = new PedidoDto();
			dto.setNombre(pedido.getNombre());
			dto.setFecha(pedido.getFecha());

			for (PedidoArticulo temp : pedido.getArticulos()) {

				ArticuloDto dtoTemp = new ArticuloDto();
				dtoTemp.setPrecio(temp.getIdArticulo().getPrecio());
				dtoTemp.setNombre(temp.getIdArticulo().getNombre());
				dtoTemp.setStock(temp.getIdArticulo().getStock());
				listaArticulos.add(dtoTemp);
			}
		}
	}
}
