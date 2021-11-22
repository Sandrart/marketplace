package edu.es.eoi.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PedidoArticulos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private Integer cantidad;
	
	@ManyToOne(targetEntity = Articulo.class, cascade = CascadeType.ALL)
	private Articulo articulo;
	
	@ManyToOne(targetEntity = Pedido.class, cascade = CascadeType.ALL)
	private Pedido pedido;
}
