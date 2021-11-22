package edu.es.eoi.entity;

import java.sql.Date;

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
@Table(name = "pedidos", schema = "marketplace")
public class Pedido {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "FECHA")
	private Date fecha;
	
	@Column(name = "NOMBRE")
	private String nombre;
	
	@ManyToOne(targetEntity = Usuario.class)
	private Usuario usuario;
	
	@ManyToOne(targetEntity = Pedido_Articulo.class)
	private Pedido_Articulo pedidoArticulos;
}
