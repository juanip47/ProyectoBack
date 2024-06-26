package com.proyecto.service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.dto.ArticuloDto;
import com.proyecto.mapper.ArticuloMapper;
import com.proyecto.model.Articulo;
import com.proyecto.model.Marca;
import com.proyecto.model.Seccion;
import com.proyecto.repository.ArticuloRepository;
import com.proyecto.repository.MarcaRepository;
import com.proyecto.repository.SeccionRepository;
import com.proyecto.service.ArticuloService;

import jakarta.transaction.Transactional;

@Service
public class ArticuloServiceImpl implements ArticuloService {
	@Autowired
	ArticuloRepository articuloRepository;
	
	@Autowired
	ArticuloMapper articuloMapper;
	
	@Autowired
	Articulo articulo;
	
	@Autowired
	SeccionRepository seccionRepository;
	
	@Autowired
	MarcaRepository marcaRepository;
	
	
	
	@Override
	public List<ArticuloDto> getArticulos() {
		List<ArticuloDto> articulosDto = articuloRepository.obtenerArticulos().stream()
				.map(articulo -> {
	                return articuloMapper.mapArticuloToArticuloDto(articulo);
	            })
		.collect(Collectors.toList());
		
		return articulosDto;
	}

	@Override
	@Transactional
	public void deleteArticulo(Integer idArticulo) {
		articuloRepository.eliminarArticuloPorId(idArticulo);
		
	}

	@Override
	public List<ArticuloDto> obtenerArticulosPorSeccion(Long idSeccion) {
		List<ArticuloDto> articulosDto = articuloRepository.obtenerArticulosPorSeccionId(idSeccion).stream()
				.map(articulo -> {
	                return articuloMapper.mapArticuloToArticuloDto(articulo);
	            })
		.collect(Collectors.toList());
		
		return articulosDto;
	}

	@Override
	public List<ArticuloDto> obtenerArticulosPorMarca(Integer idMarca) {
		List<ArticuloDto> articuloDto = articuloRepository.obtenerArticulosPorMarcaId(idMarca).stream()
				.map(articulo -> {
					return articuloMapper.mapArticuloToArticuloDto(articulo);
				})
		.collect(Collectors.toList());
		
		return articuloDto;
	}

	@Override
	@Transactional
	public ArticuloDto insertArticulo(ArticuloDto articuloDto) {
		Articulo articulo = new Articulo();
		
		articulo.setDescripcionArticulo(articuloDto.getDescripcionArticulo());
		articulo.setCantidadArticulo(articuloDto.getCantidadArticulo());
		articulo.setPrecioArticulo(articuloDto.getPrecioArticulo());
				
		Seccion seccion = seccionRepository.getSeccionById(articuloDto.getSeccion().getIdSeccion());
		
		if (seccion == null) {
			Seccion seccion2 = new Seccion();
			
			seccion2.setNombreSeccion(articuloDto.getSeccion().getNombreSeccion());
			
			seccionRepository.save(seccion2);
			
			articulo.setSeccion(seccion2);
		} else {
			articulo.setSeccion(seccion);
		}
		
		Marca marca = marcaRepository.getMarcaById(articuloDto.getMarca().getIdMarca());
		
		if (marca == null) {
			Marca marca2 = new Marca();
			
			marca2.setNombreMarca(articuloDto.getMarca().getNombreMarca());
			
			marcaRepository.save(marca2);
			
			articulo.setMarca(marca2);
		} else {
			articulo.setMarca(marca);
		}
		
		Articulo articuloEncontrado = articuloRepository.buscarArticuloPorDescripcion(articulo.getDescripcionArticulo());
		
		if (articuloEncontrado != null) {
			throw new RuntimeException("El artículo ya existe");
		} else {
			articuloRepository.insertArticulo(articulo.getDescripcionArticulo(), articulo.getCantidadArticulo()
					, articulo.getPrecioArticulo()
					, articulo.getSeccion().getIdSeccion()
					, articulo.getMarca().getIdMarca());;
		}
		
		return articuloMapper.mapArticuloToArticuloDto(articulo);
	}

	@Override
	@Transactional
	public ArticuloDto editArticuloPorId(ArticuloDto articuloDto) {
		Articulo articulo = articuloRepository.getArticuloById(articuloDto.getIdArticulo());
		
		articulo.setIdArticulo(articuloDto.getIdArticulo());
		articulo.setDescripcionArticulo(articuloDto.getDescripcionArticulo());
		articulo.setCantidadArticulo(articuloDto.getCantidadArticulo());
		articulo.setPrecioArticulo(articuloDto.getPrecioArticulo());
		
		Seccion seccion = new Seccion();
		
		if (articuloDto.getSeccion() != null) {
			seccion = seccionRepository.getSeccionById(articuloDto.getSeccion().getIdSeccion());
		}
				
		
		if (seccion == null) {
			Seccion seccion2 = new Seccion();
			
			seccion2.setNombreSeccion(articuloDto.getSeccion().getNombreSeccion());
			
			seccionRepository.save(seccion2);
			
			articulo.setSeccion(seccion2);
		} else {
			articulo.setSeccion(articuloDto.getSeccion());
		}
		
		Articulo articuloEncontrado = articuloRepository.buscarArticuloPorDescripcionConId(articulo.getDescripcionArticulo()
				,articulo.getIdArticulo());
		
		if (articuloEncontrado != null) {
			throw new RuntimeException("El artículo ya existe");
		} else {
			articuloRepository.editArticuloPorId(articulo.getDescripcionArticulo(), articulo.getCantidadArticulo()
					, articulo.getPrecioArticulo()
					, articulo.getSeccion().getIdSeccion()
					, articulo.getMarca().getIdMarca()
					, articulo.getIdArticulo());
		}
		
		return articuloMapper.mapArticuloToArticuloDto(articulo);
	}
}
 