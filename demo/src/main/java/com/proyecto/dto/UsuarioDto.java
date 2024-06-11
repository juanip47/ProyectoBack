package com.proyecto.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class UsuarioDto {
	
	private String correoUsuario;
	
	private String nombreUsuario;
	
	private String contraseniaUsuario;
	
	private String correoUsuarioOfuscado;
	
}
