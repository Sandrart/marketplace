package edu.es.eoi.marketplacespringboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.es.eoi.marketplacespringboot.entity.Articulo;

@Repository
public interface ArticuloRepository extends JpaRepository<Articulo, Integer>{
	public List<Articulo> findByNombre(String nombre);
	public List<Articulo> findByNombreContaining(String nombre);
}
