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

	public UsuarioDto find(Integer id) {

		Usuario u = repo.findById(id).get();

		UsuarioDto dto = new UsuarioDto();

		BeanUtils.copyProperties(u , dto);

		return dto;
	}

	public List<UsuarioDto> findAll() {

		List<Usuario> usuarios = repo.findAll();
		List<UsuarioDto> lista = new ArrayList<UsuarioDto>();

		for (Usuario usuario : usuarios) {
			UsuarioDto dto = new UsuarioDto();
			BeanUtils.copyProperties(usuario, dto);

			lista.add(dto);
		}

		return lista;
	}

	public void save(UsuarioDto dto) {

		Usuario entity = new Usuario();
		BeanUtils.copyProperties(dto, entity);

		repo.save(entity);
	}

	public boolean comprobarLogin(UsuarioDto dto) {

		List<Usuario> result = repo.findByNombreAndPassword(dto.getNombre(), dto.getPassword());
		
		if(result!=null&&result.size()>0) {
			return true;
		}else {
			return false;
		}
	}

}
