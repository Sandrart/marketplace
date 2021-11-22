package edu.es.eoi.marketplacespringboot.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UsuarioDto {
	private int id;
	private String nombre;
	private String password;
	
	private List<PedidoDto> pedidos;
}
