package com.proyecto.service;

import java.util.List;

import com.proyecto.dto.UsuarioDto;

public interface UsuarioService {
	
	List<UsuarioDto> getUsuarios();
	
	UsuarioDto getUsuarioPorCorreo(String correoUsuario);
	
	void deleteUsuario(String correoUsuario);
	
	UsuarioDto insertUsuario(UsuarioDto usuarioDto);
	
	UsuarioDto editUsuario(UsuarioDto usuarioDto);
}
