package edu.es.eoi.Service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.es.eoi.Dto.UsuarioDto;
import edu.es.eoi.Entity.Usuario;
import edu.es.eoi.Repository.UsuarioRepositorio;



@Service
public class UsuarioServicio {

	
	@Autowired
	UsuarioRepositorio repo;
	
	public UsuarioDto find(Integer id) {
		
		Usuario usuario = repo.findById(id).get();
		UsuarioDto dto = new UsuarioDto();
		
		BeanUtils.copyProperties(usuario, dto);
		
		return dto;
	}
	
	public List<UsuarioDto> findAll() {
		
		List<Usuario> usuarios = repo.findAll();
		List<UsuarioDto> lista = new ArrayList<UsuarioDto>();
		
		for(Usuario usuario: usuarios) {
			UsuarioDto dto = new UsuarioDto();
			BeanUtils.copyProperties(usuario, dto);
			
			
			lista.add(dto);
			
		}
		
		return lista;
		
	}
	
	
	public void save(UsuarioDto dto) {
		
		Usuario usuario = new Usuario();
		BeanUtils.copyProperties(dto, usuario);
		
		repo.save(usuario);
	}
	
	
	public boolean checkUser(UsuarioDto dto) {
		
		
		List<Usuario> result = repo
				.findByNombreAndPassword(dto
				.getNombre(), dto
				.getPassword());
		
		
		if(result != null && result.size() > 0) {
			return true;
		} else {
			return false;
			
		}
		
	}
	
}
