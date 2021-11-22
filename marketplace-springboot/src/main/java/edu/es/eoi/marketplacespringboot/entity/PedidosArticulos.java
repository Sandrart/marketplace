package edu.es.eoi.marketplacespringboot.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idArticulo", referencedColumnName = "id")
	private Articulo articulo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idPedido", referencedColumnName = "id")
	private Pedido pedido;
	
}
