package com.proyecto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
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
	
	//Eliminar un articulo por ID
	@Modifying
	@Query("DELETE from Seccion s WHERE s.idSeccion=:idSeccion")
	void eliminarSeccionPorId(@Param("idSeccion") Long idSeccion);
	
	//Insertar nuevas secciones
	@Modifying
	@Query(value = "INSERT into secciones (nombre_seccion) VALUES (:nombreSeccion)", nativeQuery = true)
	void insertSeccion(@Param("nombreSeccion") String nombreSeccion);
	
	//Buscar seccion para comprobar si ya existe en la BBDD para hacer inserts (por nombreSeccion)
	@Query("SELECT s from Seccion s WHERE s.nombreSeccion=:nombreSeccion")
	public Seccion buscarSeccionPorNombreSeccion(@Param("nombreSeccion") String nombreSeccion);
}
