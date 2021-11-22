package edu.es.eoi.Entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "articulos")
public class Articulo {

	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
		
	@Column
	private String nombre;
		
	@Column
	private Double precio;
		
	@Column
	private Integer stock; 
		
	@OneToMany(targetEntity = Pedido_Articulo.class, cascade = CascadeType.ALL)
	private List<Pedido_Articulo> pedido_Articulo;	

	
}
