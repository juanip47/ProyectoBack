package com.proyecto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.proyecto.model.Articulo;

@Repository
public interface ArticuloRepository extends CrudRepository<Articulo, Integer> {
	
	//Obtener todos los articulos
	@Query("SELECT a from Articulo a")
	public List<Articulo> obtenerArticulos();
	
	//Eliminar un articulo por ID
	@Modifying
	@Query("DELETE from Articulo a WHERE a.idArticulo=:idArticulo")
	void eliminarArticuloPorId(@Param("idArticulo") Integer idArticulo);
	
	//Flitrar y mostrar articulos por secciones (por idSeccion)
	@Query("SELECT a from Articulo a WHERE a.seccion.idSeccion=:idSeccion")
	public List<Articulo> obtenerArticulosPorSeccionId(@Param("idSeccion") Long idSeccion);
	
	//Filtrar y mostrar articulos por marcas (por idMarca)
	@Query("SELECT a from Articulo a WHERE a.marca.idMarca=:idMarca")
	public List<Articulo> obtenerArticulosPorMarcaId(@Param("idMarca") Integer idMarca);
	
	//Insertar nuevos articulos
	@Modifying
	@Query(value = "INSERT into articulos (descripcion_articulo, cantidad_articulo, precio_Articulo, id_seccion, id_marca) "
			+ "VALUES (:descripcionArticulo, :cantidadArticulo, :precioArticulo, :idSeccion, :idMarca)", nativeQuery = true)
	void insertArticulo(@Param("descripcionArticulo") String descripcionArticulo
			,@Param("cantidadArticulo") Integer cantidadArticulo
			,@Param("precioArticulo") Double precioArticulo
			,@Param("idSeccion") Long idSeccion
			,@Param("idMarca") Integer idMarca);
	
	//Buscar articulo para comprobar si ya existe en la BBDD para hacer inserts (por descripcionArticulo)
	@Query("SELECT a from Articulo a WHERE a.descripcionArticulo=:descripcionArticulo")
	public Articulo buscarArticuloPorDescripcion(@Param("descripcionArticulo") String descripcionArticulo);
	
	//Buscar articulo para comprobar si ya existe en la BBDD para hacer updates(por descripcionArticulo/idArticulo) 
	@Query("SELECT a from Articulo a WHERE a.descripcionArticulo=:descripcionArticulo AND a.idArticulo!=:idArticulo")
	public Articulo buscarArticuloPorDescripcionConId(@Param("descripcionArticulo") String descripcionArticulo
			,@Param("idArticulo") Integer idArticulo);
	
	//Modificar articulos que ya existen en la BBDD (por su id)
	@Modifying
	@Query(value = "UPDATE articulos SET descripcion_articulo=:descripcionArticulo,"
			+ "cantidad_articulo=:cantidadArticulo, precio_articulo=:precioArticulo, "
			+ "id_seccion=:idSeccion, id_marca=:idMarca WHERE id_articulo=:idArticulo", nativeQuery = true)
	void editArticuloPorId(@Param("descripcionArticulo") String descripcionArticulo
			,@Param("cantidadArticulo") Integer cantidadArticulo
			,@Param("precioArticulo") Double precioArticulo
			,@Param("idSeccion") Long idSeccion
			,@Param("idMarca") Integer idMarca
			,@Param("idArticulo") Integer idArticulo);
	
	//Obtener articulo por su id
		@Query("SELECT a from Articulo a WHERE a.idArticulo=:idArticulo")
		public Articulo getArticuloById(@Param("idArticulo") Integer idArticulo);
	
	 
}