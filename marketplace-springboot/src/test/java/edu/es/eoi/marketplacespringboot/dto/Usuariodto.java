package es.oi.marketplace.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Usuariodto {
	private int id;
	private String nombre;
	private String password;
}
