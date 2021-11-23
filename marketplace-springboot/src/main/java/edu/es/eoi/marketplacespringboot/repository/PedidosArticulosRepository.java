package edu.es.eoi.marketplacespringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.es.eoi.marketplacespringboot.entity.PedidosArticulos;

@Repository
public interface PedidosArticulosRepository extends JpaRepository<PedidosArticulos, Integer>{
	
//	public List<PedidosArticulos> findByIdPedido(Integer id);
	
}
