package com.mrgym.mrgym.Dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MembresiaDto {
   private Long id_membresia;

    private LocalDate fecha_inicio;

    private LocalDate fecha_final;

    private int duracion_meses;

    private float costo_mensual;

    private Long fk_cliente_membresia;  // Solo la ID del cliente

    private Long fk_promocion;  // Solo la ID de la promoción
}
