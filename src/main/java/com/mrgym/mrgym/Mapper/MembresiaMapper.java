package com.mrgym.mrgym.Mapper;

import com.mrgym.mrgym.Models.MembresiaEntity;
import com.mrgym.mrgym.Dto.MembresiaDto;

public class MembresiaMapper {
    // Convertir de MembresiaEntity a MembresiaDTO
    public static MembresiaDto toMembresiaDTO(MembresiaEntity membresiaEntity) {
        return MembresiaDto.builder()
                .id_membresia(membresiaEntity.getId_membresia())
                .fecha_inicio(membresiaEntity.getFecha_inicio())
                .fecha_final(membresiaEntity.getFecha_final())
                .duracion_meses(membresiaEntity.getDuracion_meses())
                .costo_mensual(membresiaEntity.getCosto_mensual())
                .fk_cliente_membresia(membresiaEntity.getClienteEntities().getId_cliente())
                .fk_promocion(membresiaEntity.getPromocionEntities() != null
                        ? membresiaEntity.getPromocionEntities().getId_promocion()
                        : null)
                .build();
    }

    // Convertir de MembresiaDTO a MembresiaEntity
    public static MembresiaEntity toMembresiaEntity(MembresiaDto membresiaDTO) {
        MembresiaEntity membresiaEntity = new MembresiaEntity();
        membresiaEntity.setId_membresia(membresiaDTO.getId_membresia());
        membresiaEntity.setFecha_inicio(membresiaDTO.getFecha_inicio());
        membresiaEntity.setFecha_final(membresiaDTO.getFecha_final());
        membresiaEntity.setDuracion_meses(membresiaDTO.getDuracion_meses());
        membresiaEntity.setCosto_mensual(membresiaDTO.getCosto_mensual());
        // Aquí debes obtener los objetos ClienteEntity y PromocionEntity
        // usando las IDs (puedes consultar la base de datos si es necesario)
        // por ejemplo, para ClienteEntity
        // membresiaEntity.setClienteEntities(clienteRepository.findById(membresiaDTO.getFk_cliente_membresia()).orElse(null));
        return membresiaEntity;
    }
}
