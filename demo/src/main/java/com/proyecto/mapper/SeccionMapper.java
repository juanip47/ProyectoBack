package com.proyecto.mapper;

import org.springframework.stereotype.Component;

import com.proyecto.dto.SeccionDto;
import com.proyecto.model.Seccion;

@Component
public class SeccionMapper {
	
	public SeccionDto mapSeccionToSeccionDto(Seccion seccion) {
		return SeccionDto.builder()
				.idSeccion(seccion.getIdSeccion())
				.nombreSeccion(seccion.getNombreSeccion()).build();
	}
	
}
