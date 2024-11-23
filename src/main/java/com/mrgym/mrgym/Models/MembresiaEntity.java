package com.mrgym.mrgym.Models;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

//import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
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

    @NotNull
   
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDate fecha_inicio;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDate fecha_final;

    @NotNull
    @Min(1)
    @Max(30)
    @Positive
    private int duracion_meses;

    //problemas con costo mensual
    
    @Positive
    private float costo_mensual;
    
    //name es el nombre de la columna y hace referencia a la clave primaria de id_cliente
    //este atributo seria la clave forean de CLiente
    @ManyToOne(targetEntity = ClienteEntity.class)
    @JoinColumn(name = "fk_cliente_membresia", referencedColumnName = "id_cliente")
    @JsonManagedReference
    private ClienteEntity clienteEntities;

    //name es el nombre de la columna y hace referencia 
    @ManyToOne(targetEntity = PromocionEntity.class)
    //le ahorra el trabajo de inferir cual sera la clave forenea 
    @JoinColumn(name = "fk_promocion", referencedColumnName = "id_promocion")
    private PromocionEntity promocionEntities;

}

