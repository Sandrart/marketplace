package edu.es.eoi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.es.eoi.dto.UsuarioDto;
import edu.es.eoi.entity.Usuario;
import edu.es.eoi.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl {
	
	@Autowired
	UsuarioRepository repo;
	
	public UsuarioDto findById(Integer id) {
		
		Usuario usu=repo.findById(id).get();
		
		UsuarioDto dto=new UsuarioDto();
		
		
		return dto;
	}
	
	public List<UsuarioDto> findAll(){
		
		List<Usuario> usuarios = repo.findAll();
		List<UsuarioDto> lista = new ArrayList<UsuarioDto>();
		
		for(Usuario usuario : usuarios) {
			
			UsuarioDto dto = new UsuarioDto();
			BeanUtils.copyProperties(usuarios, dto);
			
			lista.add(dto);
		}
		
		return lista;
	}
	
	public void save(UsuarioDto dto) {
		
		Usuario entidad = new Usuario();
		BeanUtils.copyProperties(dto, entidad);
		
		repo.save(entidad);
		
	}
	
	public void delete(Integer id) {
		
		repo.deleteById(id);
	}
	
	public void DeleteAll() {
		
		repo.deleteAll();
	}
	
}
