package edu.es.eoi.Dto;

import java.util.Date;
import java.util.List;
import edu.es.eoi.Entity.Pedido_Articulo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class PedidoDto {

	
	
	private int Id;
	
	private String nombre;
	
	private Date fecha;
	
	private List<Pedido_Articulo> pedido_Articulo;
	
	
	
	
	
}
