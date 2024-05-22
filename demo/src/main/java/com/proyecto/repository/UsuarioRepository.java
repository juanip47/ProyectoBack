package com.proyecto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.proyecto.model.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, String>{

	//Obtener todos los usuarios
	@Query("SELECT u from Usuario u")
	public List<Usuario> getUsuarios();
	
	//Eliminar usuario por correo
	@Modifying
	@Query("DELETE from Usuario u WHERE u.correoUsuario=:correoUsuario")
	void deleteUsuarioPorCorreo(@Param("correoUsuario") String correoUsuario);
	
	//Insertar nuevos usuarios
	@Modifying
	@Query(value = "INSERT into usuarios (nombre_usuario, correo_usuario, contrasenia_usuario) VALUES "
			+ "(:nombreUsuario, :correoUsuario, :contraseniaUsuario)", nativeQuery = true)
	void insertUsuario(@Param("nombreUsuario") String nombreUsuario
			,@Param("correoUsuario") String correoUsuario
			,@Param("contraseniaUsuario") String contraseniaUsuario);
	
	//Buscar usuario para comprobar si ya existe en la BBDD para hacer inserts (por correoUsuario)
	@Query("SELECT u from Usuario u WHERE u.correoUsuario=:correoUsuario")
	Usuario buscarUsuarioPorCorreoUsuario(@Param("correoUsuario") String correoUsuario);
	
	//Modificar usuarios que ya existen en la BBDD (por su correo)
	@Modifying
	@Query(value = "UPDATE usuarios SET correo_usuario=:correoUsuario, contrasenia_usuario=:contraseniaUsuario "
			+ "WHERE correo_usuario=:correoUsuario", nativeQuery = true)
	void editUsuarioPorCorreo(@Param("correoUsuario") String correoUsuario
			,@Param("contraseniaUsuario") String contraseniaUsuario);
}
