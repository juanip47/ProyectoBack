package com.proyecto.dto;


import com.proyecto.model.Seccion;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class ArticuloDto{
	
	private Integer idArticulo;
	
	private String descripcionArticulo;
	
	private Integer cantidadArticulo;
	
	private Double precioArticulo;

	private Seccion seccion;
}