package edu.es.eoi.marketplacespringboot.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table
@Entity
public class PedidosArticulos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int cantidad;
	
	@ManyToOne(targetEntity =Articulo.class, fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private Articulo articulo;
	
	@ManyToOne(targetEntity = Pedido.class,fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Pedido pedido;
	
}
