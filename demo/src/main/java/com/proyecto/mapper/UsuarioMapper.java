package com.proyecto.mapper;

import org.springframework.stereotype.Component;

import com.proyecto.dto.UsuarioDto;
import com.proyecto.model.Usuario;

@Component
public class UsuarioMapper {
	
	public UsuarioDto mapUsuarioToUsuarioDto(Usuario usuario) {
		return UsuarioDto.builder()
				.correoUsuario(usuario.getCorreoUsuario())
				.contraseniaUsuario(usuario.getContraseniaUsuario())
				.nombreUsuario(usuario.getNombreUsuario()).build();
	}

}
