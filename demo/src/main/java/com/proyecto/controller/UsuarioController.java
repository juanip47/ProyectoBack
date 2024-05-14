package com.proyecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.dto.UsuarioDto;
import com.proyecto.service.UsuarioService;

import com.proyecto.common.GeneralConstants;

@CrossOrigin
@RestController
@RequestMapping(GeneralConstants.API_V1_VALUE + GeneralConstants.TIENDA_VALUE)
public class UsuarioController {
	@Autowired
	UsuarioService usuarioService;
	
	@GetMapping("/usuarios")
	ResponseEntity<List<UsuarioDto>> getUsuarios() {
		List<UsuarioDto> usuarios = usuarioService.getUsuarios();
		return new ResponseEntity<>(usuarios, HttpStatus.OK);
	}
	
	@DeleteMapping("/usuario")
	ResponseEntity<String> deleteUsuario(@RequestParam("correoUsuario") String correoUsuario) {
		usuarioService.deleteUsuario(correoUsuario);
		return ResponseEntity.ok("Usuario" + GeneralConstants.ELIMINACION);
	}
}
