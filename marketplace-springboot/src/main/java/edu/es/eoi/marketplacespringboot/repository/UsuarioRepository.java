package edu.es.eoi.marketplacespringboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.es.eoi.marketplacespringboot.entity.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	List<Usuario> findByNombreAndPassword(String nombre, String password);
}
