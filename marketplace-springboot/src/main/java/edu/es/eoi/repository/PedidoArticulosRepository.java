package edu.es.eoi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.es.eoi.entity.PedidoArticulos;

@Repository
public interface PedidoArticulosRepository extends JpaRepository<PedidoArticulos, Integer>{

}
