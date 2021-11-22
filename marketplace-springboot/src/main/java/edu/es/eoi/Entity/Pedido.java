package edu.es.eoi.Entity;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table ( name = "pedido" )
public class Pedido {

	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	
	
	private String nombre;
	
	
	private Date fecha;
	
	@OneToMany(targetEntity = Pedido_Articulo.class, cascade = CascadeType.ALL)
	private List<Pedido_Articulo> pedido_Articulo;
	
	@ManyToOne(targetEntity = Usuario.class,cascade = CascadeType.ALL)
	private Usuario usuario;
	
	
	
}
