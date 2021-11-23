package edu.es.eoi.marketplacespringboot.dto;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PedidosArticulosDto {
	private int id;
	private int cantidad;	
	private ArticuloDto articulo;
	private PedidoDto pedido;
}
