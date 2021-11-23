package edu.es.eoi.marketplacespringboot;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import edu.es.eoi.dto.ArticuloDto;
import edu.es.eoi.dto.PedidoDto;
import edu.es.eoi.dto.UsuarioDto;
import edu.es.eoi.entity.Articulo;
import edu.es.eoi.entity.PedidoArticulos;
import edu.es.eoi.service.ArticuloService;
import edu.es.eoi.service.PedidoService;
import edu.es.eoi.service.UsuarioService;

@SpringBootTest
class MarketplaceSpringbootApplicationTests {

	@Autowired
	ArticuloService artService;
	
	@Autowired
	UsuarioService usuService;
	
	@Autowired
	PedidoService pedService;
	
	@Test
	void testArticuloService() {
		
		ArticuloDto dto = new ArticuloDto();
		dto.setNombre("Articulo test");
		dto.setPrecio(20.0);
		dto.setStock(10);
		
		artService.save(dto);
		Assertions.assertEquals("Articulo test", artService.find(1).getNombre());
		
		Assertions.assertEquals("Articulo test", artService.findByName("Art").get(0).getNombre());
		
	}
	
	@Test
	void testUsuarioService() {
		
		UsuarioDto dto = new UsuarioDto();
		dto.setNombre("Usuario test");
		dto.setPassword("pass");
		
		usuService.save(dto);
		Assertions.assertEquals("Usuario test", usuService.find(1).getNombre());
		
		boolean res = usuService.checkUser(dto);
		Assertions.assertTrue(res);
		
		Assertions.assertNotNull(usuService.findAll());

	}
	
	@Test
	void testPedidoService() {		

		//TODO: hacer testing de pedidos
	}

}
