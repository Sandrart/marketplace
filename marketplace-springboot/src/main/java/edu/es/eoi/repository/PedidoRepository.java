package edu.es.eoi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.es.eoi.entity.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

}
