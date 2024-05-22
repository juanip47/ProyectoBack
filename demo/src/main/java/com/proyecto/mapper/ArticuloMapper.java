package com.proyecto.mapper;

import org.springframework.stereotype.Component;

import com.proyecto.dto.ArticuloDto;
import com.proyecto.model.Articulo;

@Component
public class ArticuloMapper {
	
	public ArticuloDto mapArticuloToArticuloDto(Articulo articulo) {
		return ArticuloDto.builder()
				.idArticulo(articulo.getIdArticulo())
				.descripcionArticulo(articulo.getDescripcionArticulo())
				.cantidadArticulo(articulo.getCantidadArticulo())
				.precioArticulo(articulo.getPrecioArticulo())
				.seccion(articulo.getSeccion())
				.marca(articulo.getMarca()).build();
	}
	
	public Articulo mapArticuloDtoToArticulo(ArticuloDto articuloDto) {
		return Articulo.builder()
				.idArticulo(articuloDto.getIdArticulo())
				.descripcionArticulo(articuloDto.getDescripcionArticulo())
				.cantidadArticulo(articuloDto.getCantidadArticulo())
				.precioArticulo(articuloDto.getPrecioArticulo())
				.seccion(articuloDto.getSeccion())
				.marca(articuloDto.getMarca()).build();
	}
	
		
}