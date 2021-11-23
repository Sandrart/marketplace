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
		
		
		List<UsuarioDto> lista = new ArrayList<UsuarioDto>();
		
		for(Usuario usuario : repo.findAll()) {
			
			UsuarioDto dto = new UsuarioDto();
			BeanUtils.copyProperties(usuario, dto);
			
			
			lista.add(dto);
		}
		
		return lista;
	}
	
	public Usuario findEntity(Integer id) {
		return repo.findById(id).get();
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
	
	public UsuarioDto usuarioDto(Usuario usuario) {
		UsuarioDto dto = new UsuarioDto();
		BeanUtils.copyProperties(usuario, dto);
		return dto;
		
	}
	
	public Boolean existUser(UsuarioDto dto) {	
		List<Usuario> result = repo.findByNombreAndPassword(dto.getNombre(), dto.getPassword());
		if(result != null && result.size() != 0) {
			return true;
		}else {
			return false;
		}
	}
	
}
