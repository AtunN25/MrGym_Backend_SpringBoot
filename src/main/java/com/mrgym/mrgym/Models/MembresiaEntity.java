package com.mrgym.mrgym.Models;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;


import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "membresia")
public class MembresiaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_membresia;

    @NotBlank
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDate fecha_incio;

    @NotBlank
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDate fecha_final;

    @NotBlank
    @Min(1)
    @Positive
    @Size(max = 30)
    private int cantidad_meses;

    @NotBlank
    @Positive
    private float costo_mensual;
    
    //name es el nombre de la columna y hace referencia a la clave primaria de id_cliente
    @ManyToOne(targetEntity = ClienteEntity.class)
    @JoinColumn(name = "fk_cliente_membresia", referencedColumnName = "id_cliente")
    //este atributo seria la clave forean de CLiente
    private ClienteEntity clienteEntities;

    //name es el nombre de la columna y hace referencia 
    @ManyToOne(targetEntity = PromocionEntity.class)
    //le ahorra el trabajo de inferir cual sera la clave forenea 
    @JoinColumn(name = "fk_promocion", referencedColumnName = "id_promocion")
    private PromocionEntity promocionEntities;

}

