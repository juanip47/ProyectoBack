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
}
