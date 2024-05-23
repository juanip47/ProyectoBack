package com.proyecto.service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.dto.MarcaDto;
import com.proyecto.mapper.MarcaMapper;
import com.proyecto.model.Marca;
import com.proyecto.repository.MarcaRepository;
import com.proyecto.service.MarcaService;

import jakarta.transaction.Transactional;

@Service
public class MarcaServiceImpl implements MarcaService {
	@Autowired
	MarcaRepository marcaRepository;
	
	@Autowired
	MarcaMapper marcaMapper;
	
	@Autowired
	Marca marca;
	
	@Override
	public List<MarcaDto> getMarcas() {
		List<MarcaDto> marcasDto = marcaRepository.getMarcas().stream()
				.map((marca) -> marcaMapper.mapMarcaToMarcaDto(marca))
				.collect(Collectors.toList());
		return marcasDto;
	}

	@Override
	@Transactional
	public void deleteMarca(Integer idMarca) {
		marcaRepository.eliminarMarcaPorId(idMarca);
		
	}

	@Override
	@Transactional
	public MarcaDto insertMarca(MarcaDto marcaDto) {
		Marca marca = new Marca();
		
		marca.setNombreMarca(marcaDto.getNombreMarca());
		
		Marca marcaEncontrada = marcaRepository.buscarMarcaPorNombreMarca(marca.getNombreMarca());
		
		if (marcaEncontrada != null) {
			throw new RuntimeException("La marca ya existe");
		} else {
			marcaRepository.insertMarca(marca.getNombreMarca());
		}
		return marcaMapper.mapMarcaToMarcaDto(marca);
	}

}
