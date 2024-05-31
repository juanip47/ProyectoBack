package com.proyecto.mapper;

import java.nio.charset.StandardCharsets;

import org.springframework.stereotype.Component;

import com.google.common.hash.Hashing;
import com.proyecto.dto.UsuarioDto;
import com.proyecto.model.Usuario;

@Component
public class UsuarioMapper {
	
	public UsuarioDto mapUsuarioToUsuarioDtoCifrado(Usuario usuario) {
		return UsuarioDto.builder()
				.correoUsuario(usuario.getCorreoUsuario())
				.contraseniaUsuario(Hashing.sha256().hashString(usuario.getContraseniaUsuario(), StandardCharsets.UTF_8).toString())
				.nombreUsuario(usuario.getNombreUsuario()).build();
	}
	public UsuarioDto mapUsuarioToUsuarioDto(Usuario usuario) {
		return UsuarioDto.builder()
				.correoUsuario(usuario.getCorreoUsuario())
				.contraseniaUsuario(usuario.getContraseniaUsuario())
				.nombreUsuario(usuario.getNombreUsuario()).build();
	}

}
