package edu.es.eoi.marketplacespringboot.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ArticuloDto {
	private int id;
	private String nombre;
	private double precio;
	private int stock;
}
