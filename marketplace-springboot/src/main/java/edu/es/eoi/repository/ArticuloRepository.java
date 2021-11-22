package edu.es.eoi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.es.eoi.entity.Articulo;

public interface ArticuloRepository extends JpaRepository<Articulo, Integer> {

}
