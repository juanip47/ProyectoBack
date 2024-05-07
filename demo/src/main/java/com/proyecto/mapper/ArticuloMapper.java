package com.proyecto.mapper;

import org.springframework.stereotype.Component;

import com.proyecto.dto.ArticuloDto;
import com.proyecto.model.Articulo;
import com.proyecto.model.Seccion;

@Component
public class ArticuloMapper {
	
	public ArticuloDto mapArticuloToArticuloDto(Articulo articulo, Seccion seccion) {
		return ArticuloDto.builder()
				.idArticulo(articulo.getIdArticulo())
				.descripcionArticulo(articulo.getDescripcionArticulo())
				.cantidadArticulo(articulo.getCantidadArticulo())
				.precioArticulo(articulo.getPrecioArticulo())
				.seccion(seccion).build();
	}
	
	public Articulo mapArticuloDtoToArticulo(ArticuloDto articuloDto, Seccion seccion) {
		return Articulo.builder()
				.idArticulo(articuloDto.getIdArticulo())
				.descripcionArticulo(articuloDto.getDescripcionArticulo())
				.cantidadArticulo(articuloDto.getCantidadArticulo())
				.precioArticulo(articuloDto.getPrecioArticulo())
				.seccion(seccion).build();
	}
	
		
}