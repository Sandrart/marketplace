package edu.es.eoi.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
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
@Table ( name = "Pertenece_A")
public class Pedido_Articulo {

	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	@Column
	private Integer cantidad;
	
	
	@ManyToOne(targetEntity = Articulo.class, cascade = CascadeType.ALL)
	private Articulo articulo;
	
	
	@ManyToOne(targetEntity = Pedido.class, cascade = CascadeType.ALL)
	private Pedido pedido;
	
	
	
	
	
}
