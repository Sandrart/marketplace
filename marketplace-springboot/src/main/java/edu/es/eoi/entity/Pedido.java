package edu.es.eoi.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private Date fecha;
	
	@Column(nullable = false)
	private String nombre;
	
	@ManyToOne(targetEntity = Usuario.class, cascade = CascadeType.ALL)
	private Usuario usuario;
	
	@OneToMany(targetEntity = PedidoArticulos.class, cascade = CascadeType.ALL)
	private List<PedidoArticulos> pedidoArticulos;
}



