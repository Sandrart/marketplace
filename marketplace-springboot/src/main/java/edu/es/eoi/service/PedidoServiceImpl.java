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
	PedidoRepository repoPedido;

	public void save(PedidoDto dto) {

		Pedido pedido = new Pedido();
		BeanUtils.copyProperties(dto, pedido);

		repoPedido.save(pedido);

	}

	public void delete(Integer id) {

		repoPedido.deleteById(id);

	}

	public PedidoDto find(Integer id) {

		Pedido pedido = repoPedido.findById(id).get();

		PedidoDto dto = new PedidoDto();

		BeanUtils.copyProperties(pedido, dto);

		return dto;
	}

	public List<PedidoDto> findByNombre(String nombre) {

		List<Pedido> pedidos = repoPedido.findByNombreContaining(nombre);

		List<PedidoDto> lista = new ArrayList<PedidoDto>();
		for (Pedido pedido : pedidos) {

			PedidoDto dto = new PedidoDto();
			dto.setNombre(pedido.getNombre());
			dto.setFecha(pedido.getFecha());
			lista.add(dto);

		}
		return lista;

	}
}