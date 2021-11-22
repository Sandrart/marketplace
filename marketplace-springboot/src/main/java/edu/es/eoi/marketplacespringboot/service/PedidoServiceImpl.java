package edu.es.eoi.marketplacespringboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.es.eoi.marketplacespringboot.repository.PedidoRepository;

@Service
public class PedidoServiceImpl {
	@Autowired
	PedidoRepository repoPedido;
	
	
}
