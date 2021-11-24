package edu.es.eoi.marketplacespringboot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.es.eoi.marketplacespringboot.dto.ArticuloDto;
import edu.es.eoi.marketplacespringboot.entity.Articulo;
import edu.es.eoi.marketplacespringboot.repository.ArticuloRepository;

@Service
public class ArticuloServiceImpl {
	@Autowired
	ArticuloRepository repoArticulo;
	
	
	public ArticuloDto articuloDto(Articulo articulo) {
		ArticuloDto dto = new ArticuloDto();
		BeanUtils.copyProperties(articulo, dto);
		return dto;
		
	}
	
	public void save(ArticuloDto dto) {
		Articulo entity = new Articulo();
		BeanUtils.copyProperties(dto, entity);
		repoArticulo.save(entity);
		
	}
	
	public Articulo findEntity(Integer id) {
		return repoArticulo.findById(id).get();
	}
	
	public ArticuloDto find(Integer id) {
		
		Articulo user =repoArticulo.findById(id).get();
		
		ArticuloDto dto=new ArticuloDto();
		
		BeanUtils.copyProperties(user, dto);
		
		return dto;
	}
	
	public Boolean existeArticulo(ArticuloDto dto) {	
		List<Articulo> result = repoArticulo.findByNombre(dto.getNombre());
		if(result != null && result.size() != 0) {
			return true;
		}else {
			return false;
		}
	}
	
	public List<ArticuloDto> findAll() {
		List<Articulo> articulos = repoArticulo.findAll();
		List<ArticuloDto> lista= new ArrayList<ArticuloDto>();
		
		for (Articulo articulo : articulos) {
			ArticuloDto dto=new ArticuloDto();			
			BeanUtils.copyProperties(articulo, dto);
			lista.add(dto);
		}
		
		return lista;
	}

	public List<ArticuloDto> findAllNombreParcial(String nombreParcial) {
		List<Articulo> articulos = repoArticulo.findByNombreContaining(nombreParcial);
		List<ArticuloDto> lista= new ArrayList<ArticuloDto>();
		
		for (Articulo articulo : articulos) {
			ArticuloDto dto=new ArticuloDto();			
			BeanUtils.copyProperties(articulo, dto);
			lista.add(dto);
		}
		
		return lista;
	}
}
