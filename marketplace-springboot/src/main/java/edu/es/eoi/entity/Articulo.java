package edu.es.eoi.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Articulo {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String nombre;
	
	@Column
	private Double precio;
	
	@Column
	private int stock;
	
	@ManyToMany(targetEntity=Pedido.class,cascade=CascadeType.ALL)
	private Set<Pedido> pedidos;
}	
