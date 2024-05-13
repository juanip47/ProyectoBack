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

import com.proyecto.dto.SeccionDto;
import com.proyecto.service.SeccionService;

import com.proyecto.common.GeneralConstants;

@CrossOrigin
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
	
	@DeleteMapping("/seccion")
	public ResponseEntity<String> deleteSeccion(@RequestParam("idSeccion") Long idSeccion) {
		seccionService.deleteSeccion(idSeccion);
		return ResponseEntity.ok("Sección" + GeneralConstants.ELIMINACION);
	}

	@PostMapping("/nuevaSeccion")
	public ResponseEntity<String> insertArticulo(@RequestBody SeccionDto seccionDto){
		seccionService.insertSeccion(seccionDto);
		  
		return ResponseEntity.ok("Sección" + GeneralConstants.CREACION);
	}
//	  
//	  @PutMapping("/editarArticulo")
//	  public ResponseEntity<String> editArticuloPorId(@RequestBody ArticuloDto articuloDto){
//		  articuloService.editArticuloPorId(articuloDto);
//		  
//		  return ResponseEntity.ok(GeneralConstants.MODIFICACION_ARTICULO);
//	  }
}
