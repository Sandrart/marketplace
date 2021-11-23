package edu.es.eoi.service;

import java.util.ArrayList;
import java.util.List;



import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.es.eoi.dto.ArticuloDto;
import edu.es.eoi.entity.Articulo;
import edu.es.eoi.repository.ArticuloRepository;

@Service
public class ArticuloServiceImpl {

	@Autowired
	ArticuloRepository repo;
	
	public ArticuloDto find(Integer id) {
		
		Articulo articulo = repo.findById(id).get();
		ArticuloDto dto = new ArticuloDto();
		
		BeanUtils.copyProperties(articulo, dto);
		
		return dto;
	}
	
	public List<ArticuloDto> findAll(){
		
		List<Articulo> articulos = repo.findAll();
		List<ArticuloDto> lista = new ArrayList<ArticuloDto>();
		
		for(Articulo articulo : articulos) {
			
			ArticuloDto dto = new ArticuloDto();
			BeanUtils.copyProperties(articulo, dto);
			
			lista.add(dto);
		}
		
		return lista;
	}
	
	@Transactional(rollbackFor = Exception.class)
	public void save(ArticuloDto dto) {
		
		Articulo entidad = new Articulo();
		
		BeanUtils.copyProperties(dto, entidad);
		
		repo.save(entidad);
		
	}
	
	public void delete(Integer id) {
		
		repo.deleteById(id);
	}
	
	public void deleteAll() {
		
		repo.deleteAll();
	}
}
