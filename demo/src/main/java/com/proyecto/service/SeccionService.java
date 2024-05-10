package com.proyecto.service;

import java.util.List;

import com.proyecto.dto.SeccionDto;

public interface SeccionService {

	List<SeccionDto> getSecciones();
	
	void deleteSeccion(Long idSeccion);
	
//	List<ArticuloDto> obtenerArticulosPorSeccion(Long idSeccion);
//	
//	ArticuloDto insertArticulo(ArticuloDto articuloDto);
//	
//	ArticuloDto editArticuloPorId(ArticuloDto articuloDto);
	
}
