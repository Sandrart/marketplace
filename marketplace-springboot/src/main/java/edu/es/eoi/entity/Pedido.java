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
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column
	private String fecha;
	
	@Column
	private String nombre;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id", referencedColumnName="id")
	private Usuario usuario;
	
	@ManyToMany
	@JoinTable(name="PedidoArticulo", joinColumns = @JoinColumn(name="id_pedido"),
	inverseJoinColumns = @JoinColumn(name="id_articulo")
			)
	Set<Articulo> articulos;
	
	
	
	
	
	
}
