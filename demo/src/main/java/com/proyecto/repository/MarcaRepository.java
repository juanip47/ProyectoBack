package com.proyecto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.proyecto.model.Marca;
import com.proyecto.model.Marca;

@Repository
public interface MarcaRepository extends CrudRepository<Marca, Integer> {

	//Obtener todas las marcas 
	@Query("SELECT m from Marca m")
	public List<Marca> getMarcas();
	
	//Obtener marca por su id
	@Query("SELECT m from Marca m WHERE m.idMarca=:idMarca")
	public Marca getMarcaById(@Param("idMarca") Integer idMarca);
	
	//Eliminar una marca por id
	@Modifying
	@Query("DELETE from Marca m WHERE m.idMarca=:idMarca")
	void eliminarMarcaPorId(@Param("idMarca") Integer idMarca);
	
	//Insertar nuevas marcas
	@Modifying
	@Query(value = "INSERT into marcas (nombre_marca) VALUES (:nombreMarca)", nativeQuery = true)
	void insertMarca(@Param("nombreMarca") String nombreMarca);
		
	//Buscar marca para comprobar si ya existe en la BBDD para hacer inserts (por nombreMarca)
	@Query("SELECT s from Marca s WHERE s.nombreMarca=:nombreMarca")
	public Marca buscarMarcaPorNombreMarca(@Param("nombreMarca") String nombreMarca);
}
