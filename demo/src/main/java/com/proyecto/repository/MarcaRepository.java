package com.proyecto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.proyecto.model.Marca;

@Repository
public interface MarcaRepository extends CrudRepository<Marca, Integer> {

	//Obtener todas las secciones 
	@Query("SELECT m from Marca m")
	public List<Marca> getMarcas();
	
}
