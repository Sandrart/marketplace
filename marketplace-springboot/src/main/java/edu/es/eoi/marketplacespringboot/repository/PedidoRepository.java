package edu.es.eoi.marketplacespringboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.es.eoi.marketplacespringboot.entity.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer>{
	public List<Pedido> findByNombreContaining(String nombre);
}
