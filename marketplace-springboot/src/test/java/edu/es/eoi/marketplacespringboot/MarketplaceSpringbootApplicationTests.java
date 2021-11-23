package edu.es.eoi.marketplacespringboot;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.es.eoi.controller.ArticuloController;
import edu.es.eoi.controller.PedidoController;
import edu.es.eoi.controller.UsuarioController;
import edu.es.eoi.dto.ArticuloDto;
import edu.es.eoi.dto.ArticulosPedidosDto;
import edu.es.eoi.dto.PedidoDto;
import edu.es.eoi.dto.UsuarioDto;
import edu.es.eoi.entity.Pedido;
import edu.es.eoi.entity.Usuario;
import edu.es.eoi.service.ArticuloServiceImpl;
import edu.es.eoi.service.PedidoServiceImpl;
import edu.es.eoi.service.UsuarioServiceImpl;

@SpringBootTest
class MarketplaceSpringbootApplicationTests {

	@Autowired
	UsuarioServiceImpl serviceUsuario;
	
	@Autowired
	PedidoServiceImpl servicePedido;
	
	@Autowired
	ArticuloServiceImpl serviceArticulo;
	
	@Autowired 
	PedidoController controllerPedido;
	
	@Autowired
	ArticuloController controllerArticulo;
	
	@Autowired
	UsuarioController controllerUsuario;
	
	//Prueba de servicios
	
	
	
	
	
	
	
	
	//Prueba de controladores
	@Test
	void getUsuario() {
		Assertions.assertThat(controllerUsuario.getAll());
	}
	
	@Test
	void putUsuario() {
		UsuarioDto user = new UsuarioDto();
		user.setNombre("Maria");
		user.setPassword("3913");
		Assertions.assertThat(controllerUsuario.updateOne(user, 2));
	}
	
	@Test
	void postUsuario() {
		UsuarioDto user = new UsuarioDto();
		user.setNombre("Jaime");
		user.setPassword("392313");
		Assertions.assertThat(controllerUsuario.createOne(user));
	}
	
	@Test
	void validateUsuario() {
		UsuarioDto user = new UsuarioDto();
		user.setNombre("Jaime");
		user.setPassword("392313");
		Assertions.assertThat(controllerUsuario.validate(user));
	}
	
	@Test
	void getArticulo() {
		
		Assertions.assertThat(controllerArticulo.getOne(1));
	}
	
	@Test
	void postArticulo() {
		ArticuloDto articulo = new ArticuloDto();
		articulo.setPrecio(63.5);
		articulo.setNombre("Mouse");
		articulo.setStock(5);
		Assertions.assertThat(controllerArticulo.createOne(articulo));
	}
	
	@Test
	void putArticulo() {
		ArticuloDto articulo = new ArticuloDto();
		articulo.setPrecio(63.5);
		articulo.setNombre("Mouse");
		articulo.setStock(5);
		Assertions.assertThat(controllerArticulo.updateOne(articulo, 3));
	}
	
	@Test
	void getNombreArticulo() {
		
		Assertions.assertThat(controllerArticulo.getByNombre("M"));
	}
	
	@Test
	void postPedido() {
		PedidoDto pedido = new PedidoDto();
		pedido.setFecha(new Date());
		pedido.setNombre("Pedido");
		List<ArticulosPedidosDto> articulos = new ArrayList<ArticulosPedidosDto>();
		ArticulosPedidosDto articulo = new ArticulosPedidosDto();
		articulo.setId(2);
		articulo.setCantidad(1);
		articulos.add(articulo);
		pedido.setArticulos(articulos);
		Usuario user = new Usuario();
		user.setId(8);
		user.setNombre("iuwfh");
		user.setPassword("higeg");
		List<Pedido> pedidos = new ArrayList<Pedido>();
		Pedido pedidoUsuario = new Pedido();
		BeanUtils.copyProperties(pedidos, pedidoUsuario);
		pedidos.add(pedidoUsuario);
		user.setPedidos(pedidos);
		
		Assertions.assertThat(controllerPedido.createOne(pedido, user.getId()));
	}
	
	@Test
	void getPedido() {
		Assertions.assertThat(controllerPedido.getOne(1));
	}
	
	@Test
	void putPedido() {
		PedidoDto pedido = new PedidoDto();
		pedido.setFecha(new Date());
		pedido.setNombre("Pedido uno");
		List<ArticulosPedidosDto> articulos = new ArrayList<ArticulosPedidosDto>();
		ArticulosPedidosDto articulo = new ArticulosPedidosDto();
		articulo.setId(2);
		articulo.setCantidad(1);
		articulos.add(articulo);
		
		if (articulos != null) {
		pedido.setArticulos(articulos);
		}
		Assertions.assertThat(controllerPedido.updateOne(pedido, 1, 2));
	}
	
	@Test
	void getNombrePedido() {
		Assertions.assertThat(controllerPedido.getByNombre("H"));
	}
	
	@Test
	void deletePedido() {
		Assertions.assertThat(controllerPedido.deleteOne(3));
	}
	
}
