package edu.es.eoi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArticuloDto {

	private int id;
	
	private String nombre;
	
	private Double precio;
	
	private Integer stock;
}
