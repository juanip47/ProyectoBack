package com.proyecto.model;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Component
@Table(name = "secciones")

public class Seccion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idSeccion;
	
	private String nombreSeccion;
	
}
