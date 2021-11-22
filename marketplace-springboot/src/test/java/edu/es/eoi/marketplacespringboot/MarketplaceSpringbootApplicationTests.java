package edu.es.eoi.marketplacespringboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.es.eoi.dto.UsuarioDto;
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
	
	@Test
	void contextLoads() {
		
		Assertions.assertThat(serviceUsuario.findAll());
		Assertions.assertThat(servicePedido.findByNombre("Headphone"));
		Assertions.assertThat(serviceArticulo.find(1));
		
		UsuarioDto dto = new UsuarioDto();
		serviceUsuario.save(dto);
		Assertions.assertThat(serviceUsuario.find(1));
	}

}
