package com.proyecto.service;

import java.util.List;

import com.proyecto.dto.MarcaDto;

public interface MarcaService {
	
	List<MarcaDto> getMarcas();
	
	void deleteMarca(Integer idMarca);
	
	MarcaDto insertMarca(MarcaDto marcaDto);

}
