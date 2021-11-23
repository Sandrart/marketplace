package edu.es.eoi.Dto;

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
public class ArticuloDto {

	
	
    private int id;
	
	private String nombre;
	
	private Double precio;
	
	private Integer stock;
	
	
	
}
