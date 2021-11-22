package edu.es.eoi.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "usuarios", schema = "marketplace")
public class Usuario {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "NOMBRE")
	private String nombre;
	
	@Column(name = "PASSWORD")
	private String password;
	
	@OneToMany(targetEntity = Pedido.class)
	private List<Pedido> pedidos;
	
}
