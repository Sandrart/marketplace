package edu.es.eoi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.es.eoi.dto.ArticuloDto;
import edu.es.eoi.entity.Articulo;
import edu.es.eoi.repository.ArticuloRepository;

@Service
public class ArticuloServiceImpl {

	@Autowired
	ArticuloRepository repo;
	
	public ArticuloDto find(Integer id) {
		
		Articulo a = repo.findById(id).get();
		
		ArticuloDto dto = new ArticuloDto();
		
		BeanUtils.copyProperties(a, dto);
		
		return dto;
	}
	
	public List<ArticuloDto> findAll(){
		
		List<Articulo> articulos = repo.findAll();
		List<ArticuloDto> lista = new ArrayList<ArticuloDto>();
		
		for (Articulo articulo : articulos) {
			ArticuloDto dto = new ArticuloDto();
			BeanUtils.copyProperties(articulo, dto);
			
			lista.add(dto);
		}
		
		return lista;
	}
	
	public void save(ArticuloDto dto) {
		
		Articulo entity = new Articulo();
		BeanUtils.copyProperties(dto, entity);

		repo.save(entity);
	}
	
	public void delete(Integer id) {
		
		repo.deleteById(id);
	}
	
	public void deleteAll() {
		
		repo.deleteAll();
	}
	
}
