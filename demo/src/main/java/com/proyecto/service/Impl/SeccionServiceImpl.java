package com.proyecto.service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.dto.SeccionDto;
import com.proyecto.mapper.SeccionMapper;
import com.proyecto.model.Seccion;
import com.proyecto.repository.SeccionRepository;
import com.proyecto.service.SeccionService;

import jakarta.transaction.Transactional;

@Service
public class SeccionServiceImpl implements SeccionService {
	@Autowired
	SeccionRepository seccionRepository;
	
	@Autowired
	SeccionMapper seccionMapper;
	
	@Autowired
	Seccion seccion;

	@Override
	public List<SeccionDto> getSecciones() {
	    List<SeccionDto> seccionesDto = seccionRepository.getSecciones().stream()
	            .map((seccion) -> seccionMapper.mapSeccionToSeccionDto(seccion))
	            .collect(Collectors.toList());
	    return seccionesDto;
	}

	@Override
	@Transactional
	public void deleteSeccion(Long idSeccion) {
		seccionRepository.eliminarSeccionPorId(idSeccion);
		
	}

	@Override
	@Transactional
	public SeccionDto insertSeccion(SeccionDto seccionDto) {
		Seccion seccion = new Seccion();
		
		seccion.setNombreSeccion(seccionDto.getNombreSeccion());
		
		Seccion seccionEncontrada = seccionRepository.buscarSeccionPorNombreSeccion(seccion.getNombreSeccion());
		
		if (seccionEncontrada != null) {
			throw new RuntimeException("La sección ya existe");
		} else {
			seccionRepository.insertSeccion(seccion.getNombreSeccion());
		}
		
		
		return seccionMapper.mapSeccionToSeccionDto(seccion);
	}
}
