package edu.es.eoi.marketplacespringboot.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String nombre;
	
	private Date fecha;
	
	@ManyToOne(targetEntity = Usuario.class,fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private Usuario usuario;
	
	@OneToMany(targetEntity = PedidosArticulos.class,fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<PedidosArticulos> pedidosArticulos;
	
}
