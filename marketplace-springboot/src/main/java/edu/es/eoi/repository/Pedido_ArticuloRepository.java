package edu.es.eoi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Pedido_ArticuloRepository extends JpaRepository<Pedido_ArticuloRepository, Integer>{

}
