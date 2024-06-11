package com.proyecto.mapper;

import java.nio.charset.StandardCharsets;
import java.util.Iterator;

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
	
	public UsuarioDto mapUsuarioToUsuarioDtoOfuscado(Usuario usuario) {
		
		String correo = usuario.getCorreoUsuario();
		
		int posicionFinal = correo.indexOf('@');
		String dominioCorreo = correo.substring(posicionFinal);
		
		int mitadCorreo = posicionFinal/2;
		
		String parteNoOfuscada = correo.substring(0, mitadCorreo);
		
		String parteParaOfuscar = correo.substring(mitadCorreo, posicionFinal);
		String parteOfuscada = "";
		
		for (int i = 0; i < parteParaOfuscar.length(); i++) {
			parteOfuscada += '*';
		}
		
		String correoOfuscado = parteNoOfuscada.concat(parteOfuscada).concat(dominioCorreo);
		
		
		return UsuarioDto.builder()
				.correoUsuario(correoOfuscado)
				.contraseniaUsuario(usuario.getContraseniaUsuario())
				.nombreUsuario(usuario.getNombreUsuario()).build();
	}

}
