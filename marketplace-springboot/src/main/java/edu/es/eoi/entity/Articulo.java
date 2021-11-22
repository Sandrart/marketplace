package edu.es.eoi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "articulos", schema = "marketplace")
public class Articulo {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "NOMBRE")
	private String nombre;
	
	@Column(name = "PRECIO")
	private double precio;
	
	@Column(name = "STOCK")
	private int stock;
	
	@ManyToOne(targetEntity = Pedido_Articulo.class)
	private Pedido_Articulo pedidoArticulo;
}
