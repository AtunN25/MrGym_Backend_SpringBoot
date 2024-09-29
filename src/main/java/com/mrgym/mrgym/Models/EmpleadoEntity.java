package com.mrgym.mrgym.Models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
// import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "empleado")
public class EmpleadoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_empleado;

    @NotBlank
    @Size(max = 30)
    private String nombre_empleado;

    @NotBlank
    @Size(max = 30)
    private String apellido_empleado;

    @Size(min = 9, max = 15) 
    @NotBlank
    private String telefono_empleado;

    @Size(min = 8, max = 12) 
    @NotBlank
    private String dni_empleado;

    @Size(max = 30)
    private String usuario_empleado;

    @Size(max = 60)
    private String contrasenia_empleado;

    @ManyToOne(targetEntity = CargoEntity.class)
    @JoinColumn(name = "fk_cargo", referencedColumnName = "id_cargo")
    //este atributo seria la clave forean de CLiente
    private CargoEntity cargoEntity;

    @OneToMany(cascade = CascadeType.ALL,targetEntity = AsistenciaEntity.class,fetch = FetchType.LAZY,mappedBy="empleadoEntity")
    private List<AsistenciaEntity> asistenciaEntities;

   
    
}
