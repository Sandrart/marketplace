package edu.es.eoi.marketplacespringboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.es.eoi.marketplacespringboot.dto.ArticuloDto;
import edu.es.eoi.marketplacespringboot.service.ArticuloServiceImpl;

@SpringBootTest
class MarketplaceSpringbootApplicationTests {

	@Autowired
	ArticuloServiceImpl articuloService;
	
	@Test
	void tests() {
		
		ArticuloDto dto = new ArticuloDto();
		dto.setNombre("TV");
		dto.setPrecio(100);
		dto.setStock(10);
		
		articuloService.save(dto);
		
	}

}
