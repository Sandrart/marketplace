package edu.es.eoi.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import edu.es.eoi.Entity.Pedido;

@Repository
public interface PedidoRepositorio extends JpaRepository<Pedido, Long> {

	public List<Pedido> findByNombreContaining(String str);

	public Optional<Pedido> findById(Integer id);
	
	
	
}
