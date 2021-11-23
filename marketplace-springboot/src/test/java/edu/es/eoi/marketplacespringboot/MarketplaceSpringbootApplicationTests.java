package edu.es.eoi.marketplacespringboot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import edu.es.eoi.dto.ArticuloDto;
import edu.es.eoi.service.ArticuloService;

@SpringBootTest
class MarketplaceSpringbootApplicationTests {

	@Autowired
	ArticuloService artService;
	
	@Test
	void testArticuloService() {
		
		ArticuloDto dto = new ArticuloDto();
		dto.setNombre("Articulo test");
		dto.setPrecio(20.0);
		dto.setStock(10);
		
		artService.save(dto);
		Assertions.assertEquals("Articulo test", artService.find(1).getNombre());
		
		Assertions.assertEquals("Articulo test", artService.findByName("Art").get(0).getNombre());
		
//		RestTemplate template= new RestTemplate();
//		ResponseEntity<ArticuloDto> resp = template.getForEntity("http://localhost:8080/articulo/1", ArticuloDto.class);
//		
//		Assertions.assertEquals(HttpStatus.OK, resp.getStatusCode());
	}

}
