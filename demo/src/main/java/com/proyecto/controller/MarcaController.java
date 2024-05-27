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

import com.proyecto.dto.MarcaDto;
import com.proyecto.service.MarcaService;

import com.proyecto.common.GeneralConstants;

@CrossOrigin
@RestController
@RequestMapping(GeneralConstants.API_V1_VALUE + GeneralConstants.TIENDA_VALUE)
public class MarcaController {
	@Autowired
	MarcaService marcaService;

	@GetMapping("/marcas")
	public ResponseEntity<List<MarcaDto>> getMarcas() {
		List<MarcaDto> marcas = marcaService.getMarcas();
		return new ResponseEntity<>(marcas, HttpStatus.OK);
	}
	
	@DeleteMapping("/marca")
	public ResponseEntity<String> deleteMarca(@RequestParam("idMarca") Integer idMarca) {
		marcaService.deleteMarca(idMarca);
		return ResponseEntity.ok("Marca" + GeneralConstants.ELIMINACION);
	}
	
	@PostMapping("/nuevaMarca")
	public ResponseEntity<String> insertMarca(@RequestBody MarcaDto marcaDto) {
		marcaService.insertMarca(marcaDto);
		return ResponseEntity.ok("Marca" + GeneralConstants.CREACION);
	}
	
	@PutMapping("/editarMarca")
	public ResponseEntity<String> editMarca(@RequestBody MarcaDto marcaDto) {
		marcaService.editMarcaPorId(marcaDto);
		return ResponseEntity.ok("Marca" + GeneralConstants.MODIFICACION);
	}
	
}
