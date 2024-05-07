package com.proyecto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.proyecto.model.Seccion;

@Repository
public interface SeccionRepository extends CrudRepository<Seccion, Long>{
	
	//Obtener todas las secciones 
	@Query("SELECT s from Seccion s")
	public List<Seccion> getSecciones();
	
	//Obtener seccion por su id
	@Query("SELECT s from Seccion s WHERE s.idSeccion=:idSeccion")
	public Seccion getSeccionById(@Param("idSeccion") Long idSeccion);
}
