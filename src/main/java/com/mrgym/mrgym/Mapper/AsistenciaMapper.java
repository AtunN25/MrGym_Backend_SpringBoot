package com.mrgym.mrgym.Mapper;

import com.mrgym.mrgym.Dto.AsistenciaDto;
import com.mrgym.mrgym.Models.AsistenciaEntity;
import com.mrgym.mrgym.Models.ClienteEntity;
import com.mrgym.mrgym.Models.EmpleadoEntity;

public class AsistenciaMapper {

    // Convertir de AsistenciaEntity a AsistenciaDTO
    public static AsistenciaDto toAsistenciaDTO(AsistenciaEntity asistenciaEntity) {
        return AsistenciaDto.builder()
                .id_asistencia(asistenciaEntity.getId_asistencia())
                .fecha_asistencia(asistenciaEntity.getFecha_asistencia())
                .tipo_asistencia(asistenciaEntity.getTipo_asistencia())
                .fk_cliente_asistencia(asistenciaEntity.getClienteEntities().getId_cliente())
                .fk_empleado_asistencia(asistenciaEntity.getEmpleadoEntity().getId_empleado())
                .build();
    }

    // Convertir de AsistenciaDTO a AsistenciaEntity
    public static AsistenciaEntity toAsistenciaEntity(AsistenciaDto asistenciaDTO) {
        AsistenciaEntity asistenciaEntity = new AsistenciaEntity();
        asistenciaEntity.setId_asistencia(asistenciaDTO.getId_asistencia());
        asistenciaEntity.setFecha_asistencia(asistenciaDTO.getFecha_asistencia());
        asistenciaEntity.setTipo_asistencia(asistenciaDTO.getTipo_asistencia());
        
        // Suponemos que ya tienes los métodos en tu repositorio para obtener las entidades por su ID.
        ClienteEntity cliente = new ClienteEntity();
        cliente.setId_cliente(asistenciaDTO.getFk_cliente_asistencia());
        asistenciaEntity.setClienteEntities(cliente);
        
        EmpleadoEntity empleado = new EmpleadoEntity();
        empleado.setId_empleado(asistenciaDTO.getFk_empleado_asistencia());
        asistenciaEntity.setEmpleadoEntity(empleado);
        
        return asistenciaEntity;
    }
}