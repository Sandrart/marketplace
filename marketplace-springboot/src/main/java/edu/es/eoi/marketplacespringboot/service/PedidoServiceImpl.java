package edu.es.eoi.marketplacespringboot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.es.eoi.marketplacespringboot.dto.ArticuloDto;
import edu.es.eoi.marketplacespringboot.dto.PedidoArticulosDto;
import edu.es.eoi.marketplacespringboot.dto.PedidoDto;
import edu.es.eoi.marketplacespringboot.entity.Articulo;
import edu.es.eoi.marketplacespringboot.entity.Pedido;
import edu.es.eoi.marketplacespringboot.entity.PedidosArticulos;
import edu.es.eoi.marketplacespringboot.entity.Usuario;
import edu.es.eoi.marketplacespringboot.repository.ArticuloRepository;
import edu.es.eoi.marketplacespringboot.repository.PedidoRepository;
import edu.es.eoi.marketplacespringboot.repository.UsuarioRepository;

@Service
public class PedidoServiceImpl {
	@Autowired
	PedidoRepository repoPedido;

	@Autowired
	ArticuloRepository articuloRepository;

	@Autowired
	UsuarioRepository usuarioRepository;

	public void save(PedidoDto dto, int usuario) {
		if (usuarioRepository.findById(usuario) != null) {
			Pedido pedido = new Pedido();
			pedido.setNombre(dto.getNombre());
			pedido.setFecha(dto.getFecha());
			
			findUsuario(usuario, pedido);
			
			List<PedidosArticulos> lista = mapeoPedidoArticulosDto(dto, pedido);

			pedido.setPedidosArticulos(lista);

			repoPedido.save(pedido);
		}

	}
	
	public void actualizar(PedidoDto dto, int usuario) {
		Pedido p = repoPedido.findById(dto.getId()).get();
		p.setId(dto.getId());
		p.setFecha(dto.getFecha());
		p.setNombre(dto.getNombre());
	
		
//		List<PedidosArticulos> lista = mapeoPedidoArticulosDto(dto, p);
//
//		p.setPedidosArticulos(lista);
		
		repoPedido.save(p);
	}
	
	
	private List<PedidosArticulos> mapeoPedidoArticulosDto(PedidoDto dto, Pedido pedido) {
		List<PedidoArticulosDto> articulos = dto.getArticulos();
		List<PedidosArticulos> lista = new ArrayList<PedidosArticulos>();

		for (PedidoArticulosDto pedidoArticulosDto : articulos) {

			Articulo articulo = articuloRepository.findById(pedidoArticulosDto.getId()).get();

			PedidosArticulos p = new PedidosArticulos();
			p.setArticulo(articulo);
			p.setPedido(pedido);
			p.setCantidad(pedidoArticulosDto.getCantidad());

			if (articulo.getPedidosArticulos() != null) {
				articulo.getPedidosArticulos().add(p);
			} else {
				articulo.setPedidosArticulos(new ArrayList<PedidosArticulos>());
				articulo.getPedidosArticulos().add(p);
			}

			lista.add(p);
		}
		return lista;
	}

	private void findUsuario(int usuario, Pedido pedido) {
		Usuario user = usuarioRepository.findById(usuario).get();
		pedido.setUsuario(user);
		user.getPedidos().add(pedido);
	}

	public void delete(Integer id) {
		Pedido p = repoPedido.findById(id).get();
		p.getUsuario().getPedidos().remove(p);
		repoPedido.deleteById(id);
	}

	public PedidoDto find(Integer id) throws NoSuchElementException {

		Pedido pedido = repoPedido.findById(id).get();

		PedidoDto dto = new PedidoDto();
		dto.setFecha(pedido.getFecha());
		dto.setNombre(pedido.getNombre());
		dto.setId(pedido.getId());

		List<PedidoArticulosDto> lista = muestraCamposArticulo(pedido);

		dto.setArticulos(lista);

		return dto;
	}

	private List<PedidoArticulosDto> muestraCamposArticulo(Pedido pedido) {
		List<PedidoArticulosDto> lista = new ArrayList<PedidoArticulosDto>();

		for (PedidosArticulos articulo : pedido.getPedidosArticulos()) {
			PedidoArticulosDto temp = new PedidoArticulosDto();
			temp.setId(articulo.getId());
			temp.setCantidad(articulo.getCantidad());
			lista.add(temp);
		}
		return lista;
	}

	public List<PedidoDto> findByNombre(String nombre) {
		
		List<Pedido> pedidos = repoPedido.findByNombreContaining(nombre);

		List<PedidoDto> lista = new ArrayList<PedidoDto>();

		for (Pedido pedido : pedidos) {
			List<ArticuloDto> listaArticulos = new ArrayList<ArticuloDto>();

			PedidoDto dto = new PedidoDto();
			dto.setId(pedido.getId());
			dto.setNombre(pedido.getNombre());
			dto.setFecha(pedido.getFecha());
			
			for (PedidosArticulos temp : pedido.getPedidosArticulos()) {

				ArticuloDto dtoTemp = new ArticuloDto();
				dtoTemp.setPrecio(temp.getArticulo().getPrecio());
				dtoTemp.setNombre(temp.getArticulo().getNombre());
				dtoTemp.setStock(temp.getArticulo().getStock());
				listaArticulos.add(dtoTemp);
			}

			List<PedidoArticulosDto> articulos = muestraCamposArticulo(pedido);

			BeanUtils.copyProperties(listaArticulos, articulos);

			dto.setArticulos(articulos);

			lista.add(dto);

		}
		return lista;

	}

}
