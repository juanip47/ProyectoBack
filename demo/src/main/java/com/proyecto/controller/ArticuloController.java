package com.proyecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.dto.ArticuloDto;
import com.proyecto.service.ArticuloService;

import com.proyecto.common.GeneralConstants;

@CrossOrigin
@RestController
@RequestMapping(GeneralConstants.API_V1_VALUE + GeneralConstants.TIENDA_VALUE)
public class ArticuloController {
	@Autowired
	ArticuloService articuloService;
  
  @GetMapping("/articulos")
  public ResponseEntity<List<ArticuloDto>> getArticulos() {
      List<ArticuloDto> articulos = articuloService.getArticulos();
      return new ResponseEntity<>(articulos, HttpStatus.OK);
  }
  
  @DeleteMapping("/articulo")
  public ResponseEntity<String> deleteArticulo(@RequestParam("idArticulo") Integer idArticulo) {
	  articuloService.deleteArticulo(idArticulo);
	  return ResponseEntity.ok("Artículo" + GeneralConstants.ELIMINACION);
  }
  
  @GetMapping("/articulos/seccion")
  public ResponseEntity<List<ArticuloDto>> obtenerArticulosPorSeccion(@RequestParam("idSeccion") Long idSeccion){
	  List<ArticuloDto> articulosFiltrados = articuloService.obtenerArticulosPorSeccion(idSeccion);
	  return new ResponseEntity<>(articulosFiltrados, HttpStatus.OK);
  }
  
  @PostMapping("/nuevoArticulo")
  public ResponseEntity<String> insertArticulo(@RequestBody ArticuloDto articuloDto){
	  articuloService.insertArticulo(articuloDto);
	  
	  return ResponseEntity.ok("Artículo" + GeneralConstants.CREACION);
  }
  
  @PutMapping("/editarArticulo")
  public ResponseEntity<String> editArticuloPorId(@RequestBody ArticuloDto articuloDto){
	  articuloService.editArticuloPorId(articuloDto);
	  
	  return ResponseEntity.ok("Artículo" + GeneralConstants.MODIFICACION);
  }
  
}