package edu.es.eoi.Dto;

import java.util.Date;
import java.util.List;
import edu.es.eoi.Entity.Pedido_Articulo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PedidoDto {

	
	private int Id;
	
	private String nombre;
	
	private Date fecha;
	
	private List<Pedido_Articulo> pedido_Articulo;
	
	
	
	
	
}
