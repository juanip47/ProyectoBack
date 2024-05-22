package com.proyecto.mapper;

import org.springframework.stereotype.Component;

import com.proyecto.dto.MarcaDto;
import com.proyecto.model.Marca;

@Component
public class MarcaMapper {

	public MarcaDto mapMarcaToMarcaDto(Marca marca) {
		return MarcaDto.builder()
				.idMarca(marca.getIdMarca())
				.nombreMarca(marca.getNombreMarca()).build();
	}
	
}
