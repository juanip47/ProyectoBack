package com.proyecto.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.proyecto.model.Articulo;
import com.proyecto.model.Seccion;
import com.proyecto.repository.ArticuloRepository;
import com.proyecto.repository.SeccionRepository;

@Component
public class InitialData implements CommandLineRunner{
	@Autowired 
	ArticuloRepository articuloRepository;
	
	@Autowired
	SeccionRepository seccionRepository;

	@Override
	public void run(String... args) throws Exception {
		Seccion bebidas = new Seccion();
		bebidas.setNombreSeccion("Bebidas");
		seccionRepository.save(bebidas);
		
		Seccion pasta = new Seccion();
		pasta.setNombreSeccion("Pasta");
		seccionRepository.save(pasta);
		
		Articulo cervezaMahouLata = new Articulo(); 
		cervezaMahouLata.setDescripcionArticulo("Cerveza Mahou lata"); 
		cervezaMahouLata.setPrecioArticulo(0.94); 
		cervezaMahouLata.setCantidadArticulo(25);
		cervezaMahouLata.setSeccion(bebidas);
		articuloRepository.save(cervezaMahouLata);
		
		Articulo cocaCola2L = new Articulo();
		cocaCola2L.setDescripcionArticulo("Botella de 2 litros de Coca-Cola");
		cocaCola2L.setPrecioArticulo(2.99);
		cocaCola2L.setCantidadArticulo(135);
		cocaCola2L.setSeccion(bebidas);
		articuloRepository.save(cocaCola2L);
		
		Articulo macarronesGallo = new Articulo(); 
		macarronesGallo.setDescripcionArticulo("Macarrones Gallo"); 
		macarronesGallo.setPrecioArticulo(2.99); 
		macarronesGallo.setCantidadArticulo(100);
		macarronesGallo.setSeccion(pasta);
		articuloRepository.save(macarronesGallo);
		
		
	}

}