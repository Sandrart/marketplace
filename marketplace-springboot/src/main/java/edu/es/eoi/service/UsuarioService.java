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
public class UsuarioService {

	@Autowired
	UsuarioRepository repo;
	
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
}
