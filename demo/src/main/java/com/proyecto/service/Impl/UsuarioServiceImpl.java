package com.proyecto.service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.dto.UsuarioDto;
import com.proyecto.mapper.UsuarioMapper;
import com.proyecto.model.Usuario;
import com.proyecto.repository.UsuarioRepository;
import com.proyecto.service.UsuarioService;

import jakarta.transaction.Transactional;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	UsuarioMapper usuarioMapper;
	
	@Autowired
	Usuario usuario;

	@Override
	public List<UsuarioDto> getUsuarios() {
		List<UsuarioDto> usuariosDto = usuarioRepository.getUsuarios().stream()
				.map((usuario) -> usuarioMapper.mapUsuarioToUsuarioDto(usuario))
				.collect(Collectors.toList());
		return usuariosDto;
	}

	@Override
	@Transactional
	public void deleteUsuario(String correoUsuario) {
		usuarioRepository.deleteUsuarioPorCorreo(correoUsuario);		
	}
}
