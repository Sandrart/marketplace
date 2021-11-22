package edu.es.eoi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArticuloDto {

	private int id;
	
	private String nombre;
	
	private Double precio;
	
	private Integer stock;
}
