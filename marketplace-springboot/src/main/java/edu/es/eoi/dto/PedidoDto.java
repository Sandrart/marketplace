package edu.es.eoi.dto;

import java.sql.Date;
import java.util.List;

import edu.es.eoi.entity.Pedido_Articulo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PedidoDto {

	private int id;
	
	private String nombre;
	
	private Date fecha;
	
	private List<Pedido_Articulo> pedidoArticulos;
}
