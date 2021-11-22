package edu.es.eoi.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import edu.es.eoi.Entity.Usuario;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario,Long> {

 public List<Usuario> findByNombreAndPassword(String nombre, String password);

  public Optional<Usuario> findById(Integer id);

	
	
}
