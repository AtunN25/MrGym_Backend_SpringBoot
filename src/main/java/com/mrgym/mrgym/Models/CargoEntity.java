package com.mrgym.mrgym.Models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
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
@Table(name = "cargo")

public class CargoEntity {
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_cargo;

    @NotBlank
    @Size(max = 30)
    private String nombre_cargo;

    @OneToMany(cascade = CascadeType.ALL,targetEntity = EmpleadoEntity.class,fetch = FetchType.LAZY,mappedBy = "cargoEntity")
    //es una lista de membresia que tiene 
    private List<EmpleadoEntity> empleadoEntities;
}
