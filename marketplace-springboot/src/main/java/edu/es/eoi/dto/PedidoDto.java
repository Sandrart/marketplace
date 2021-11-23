package edu.es.eoi.dto;

import java.util.List;

import edu.es.eoi.entity.Articulo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PedidoDto {

	private int id;
	private String nombre;
	private String fecha;
	private PedidoArticuloDto articuloDto;
	private List<ArticuloDto> articulos;
	
	public void setArticulo(String nombre2) {
		// TODO Auto-generated method stub
		
	}
}
