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
public class ArticuloService {

	
	@Autowired
	ArticuloRepository repo;

	public ArticuloDto find(Integer id) {

		Articulo articulo = repo.findById(id).get();
		ArticuloDto dto = new ArticuloDto();

		BeanUtils.copyProperties(articulo, dto);

		return dto;
	}
	
	public List<ArticuloDto> findByName(String str){
		
		List<Articulo> articulos = repo.findByNombreContaining(str);
		List<ArticuloDto> lista = new ArrayList<ArticuloDto>();
		
		for(Articulo articulo: articulos) {
			ArticuloDto dto = new ArticuloDto();
			BeanUtils.copyProperties(articulo, dto);
			
			lista.add(dto);
		}
		
		return lista;
	}
	
	public void save(ArticuloDto dto) {
		
		Articulo articulo = new Articulo();
		BeanUtils.copyProperties(dto, articulo);
		
		repo.save(articulo);
	}
}
