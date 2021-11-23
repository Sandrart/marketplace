package edu.es.eoi.entity;


import java.util.Set;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Pedido {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String fecha;
	
	@Column
	private String nombre;
	
	
	@ManyToOne(targetEntity = Usuario.class,fetch=FetchType.LAZY)	
	private Usuario usuario;
	
	@ManyToMany
	@JoinTable(name="pedidoarticulo", joinColumns = @JoinColumn(name="idPedido"),
	inverseJoinColumns = @JoinColumn(name="idArticulo"))
	private Set<Articulo> articulos;
	
	
	
	
	
	
}
