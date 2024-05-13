package com.proyecto.service;

import java.util.List;

import com.proyecto.dto.SeccionDto;

public interface SeccionService {

	List<SeccionDto> getSecciones();
	
	void deleteSeccion(Long idSeccion);
	
	SeccionDto insertSeccion(SeccionDto seccionDto);
//	
//	ArticuloDto editArticuloPorId(ArticuloDto articuloDto);
	
}
