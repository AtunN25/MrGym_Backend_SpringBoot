package com.mrgym.mrgym.Models;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "asistencia")
public class AsistenciaEntity {
 @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_asistencia;

    @NotBlank
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private String fecha_asistencia;

    @NotBlank
    @Enumerated(EnumType.STRING)
    private TipoAsistencia tipo_asistencia;

    @ManyToOne(targetEntity = ClienteEntity.class)
    @JoinColumn(name = "fk_cliente_asistencia", referencedColumnName = "id_cliente")
    //este atributo seria la clave forean de CLiente
    private ClienteEntity clienteEntities;

    @ManyToOne(targetEntity = EmpleadoEntity.class)
    @JoinColumn(name = "fk_empleado", referencedColumnName = "id_empleado")
    //este atributo seria la clave forean de CLiente
    private EmpleadoEntity empleadoEntity;


}


