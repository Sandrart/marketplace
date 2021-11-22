package edu.es.eoi.dto;

import edu.es.eoi.entity.Usuario;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDto {

	private int id;
	
	private String nombre;
	
	private Usuario password;
	
}
