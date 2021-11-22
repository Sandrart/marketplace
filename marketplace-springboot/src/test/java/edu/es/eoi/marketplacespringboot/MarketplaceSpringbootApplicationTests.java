package edu.es.eoi.marketplacespringboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.es.eoi.dto.UsuarioDto;
import edu.es.eoi.service.UsuarioServiceImpl;

@SpringBootTest
class MarketplaceSpringbootApplicationTests {

	@Autowired
	UsuarioServiceImpl serviceUsuario;
	
	@Test
	void contextLoads() {
		
//		Assertions.assertThat(serviceUsuario.findAll());
//		UsuarioDto dto = new UsuarioDto();
//		serviceUsuario.save(dto);
//		Assertions.assertThat(serviceUsuario.find(1));
	}

}
