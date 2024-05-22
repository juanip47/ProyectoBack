package com.proyecto.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class MarcaDto {
	
	private Integer idMarca;
	
	private String nombreMarca;

}
