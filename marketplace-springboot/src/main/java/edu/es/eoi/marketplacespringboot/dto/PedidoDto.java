package edu.es.eoi.marketplacespringboot.dto;

import java.sql.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PedidoDto {
	
	private int id;
	private String nombre;
	private Date fecha;

	private List<PedidoArticulosDto> articulos;
	
}
