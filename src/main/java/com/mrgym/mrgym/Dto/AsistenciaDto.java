package com.mrgym.mrgym.Dto;

import com.mrgym.mrgym.Models.TipoAsistencia;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AsistenciaDto {

    private Long id_asistencia;
    private String fecha_asistencia;
    private TipoAsistencia tipo_asistencia;
    private Long fk_cliente_asistencia;  // ID de cliente
    private Long fk_empleado_asistencia; // ID de empleado
}