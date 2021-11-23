package edu.es.eoi.marketplacespringboot.dto;

import java.sql.Date;

import lombok.Data;


@Data
public class ArticulosPedidosDto {
	private int id;
	private int cantidad;
	private Date fecha;
}
