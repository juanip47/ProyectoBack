package com.proyecto.model;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "articulos")

public class Articulo {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idArticulo;
  
  private String descripcionArticulo;
  
  private Integer cantidadArticulo;
  
  private Double precioArticulo;
  
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "idSeccion", referencedColumnName = "idSeccion")
  private Seccion seccion;
  
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "idMarca", referencedColumnName = "idMarca")
  private Marca marca;
}
