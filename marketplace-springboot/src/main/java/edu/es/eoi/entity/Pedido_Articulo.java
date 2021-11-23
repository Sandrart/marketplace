package edu.es.eoi.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "articulos", schema = "marketplace")
public class Pedido_Articulo {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "CANTIDAD")
	private String cantidad;
	
	@OneToMany(targetEntity = Pedido.class, cascade = CascadeType.ALL)
	private List<Pedido> pedidos;

	@OneToMany(targetEntity = Articulo.class, cascade = CascadeType.ALL)
	private List<Articulo> articulos;
}
