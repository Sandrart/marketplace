package edu.es.eoi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "pedidoarticulo")
@Getter
@Setter
public class PedidoArticulo {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column
	private int idPedido;
	
	@Column
	private int idArticulo;
	
	@Column(name="cantidad")
	private int cantidad;
	
	
	
	
}
