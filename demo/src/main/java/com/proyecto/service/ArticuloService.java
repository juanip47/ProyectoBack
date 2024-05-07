package com.proyecto.service;

import java.util.List;

import com.proyecto.dto.ArticuloDto;

public interface ArticuloService {

	List<ArticuloDto> getArticulos();
	
	void deleteArticulo(Integer idArticulo);
	
	List<ArticuloDto> obtenerArticulosPorSeccion(Long idSeccion);
	
	ArticuloDto insertArticulo(ArticuloDto articuloDto);
	
	ArticuloDto editArticuloPorId(ArticuloDto articuloDto);
}
