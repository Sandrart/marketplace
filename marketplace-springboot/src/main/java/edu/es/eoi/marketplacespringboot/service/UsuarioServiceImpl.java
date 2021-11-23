package edu.es.eoi.marketplacespringboot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.es.eoi.marketplacespringboot.dto.UsuarioDto;
import edu.es.eoi.marketplacespringboot.entity.Usuario;
import edu.es.eoi.marketplacespringboot.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl {
	@Autowired
	UsuarioRepository repoUsuario;

	
	
	public void save(UsuarioDto dto) {
		Usuario entity = new Usuario();
		BeanUtils.copyProperties(dto, entity);
		repoUsuario.save(entity);
		
	}
	
	
	
	public Usuario findEntity(Integer id) {
		return repoUsuario.findById(id).get();
	}
	
	public UsuarioDto find(Integer id) {
		
		Usuario user =repoUsuario.findById(id).get();
		
		UsuarioDto dto=new UsuarioDto();
		
		BeanUtils.copyProperties(user, dto);
		
		return dto;
	}



	public Boolean existUser(UsuarioDto dto) {	
		List<Usuario> result = repoUsuario.findByNombreAndPassword(dto.getNombre(), dto.getPassword());
		if(result != null && result.size() != 0) {
			return true;
		}else {
			return false;
		}
	}

	public UsuarioDto usuarioDto(Usuario usuario) {
		UsuarioDto dto = new UsuarioDto();
		BeanUtils.copyProperties(usuario, dto);
		return dto;
		
	}


	public List<UsuarioDto> findAll() {
		List<Usuario> usuarios = repoUsuario.findAll();
		List<UsuarioDto> lista= new ArrayList<UsuarioDto>();
		
		for (Usuario user : usuarios) {
			UsuarioDto dto=new UsuarioDto();			
			BeanUtils.copyProperties(user, dto);
			lista.add(dto);
		}
		
		return lista;
	}
	
	
}
