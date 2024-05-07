package com.proyecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.dto.SeccionDto;
import com.proyecto.service.SeccionService;

import com.proyecto.common.GeneralConstants;

@RestController
@RequestMapping(GeneralConstants.API_V1_VALUE + GeneralConstants.TIENDA_VALUE)
public class SeccionController {
	@Autowired
	SeccionService seccionService;
	
	@GetMapping("/secciones")
	 public ResponseEntity<List<SeccionDto>> getSecciones() {
	      List<SeccionDto> secciones = seccionService.getSecciones();
	      return new ResponseEntity<>(secciones, HttpStatus.OK);
	  }
}
