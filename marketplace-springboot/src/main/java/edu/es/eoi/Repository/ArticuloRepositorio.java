package edu.es.eoi.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import edu.es.eoi.Entity.Articulo;


@Repository
public interface ArticuloRepositorio extends JpaRepository<Articulo, Long> {

	
	public List<Articulo> findByNombreContaining(String str);
	
	
	
}
