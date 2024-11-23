package com.mrgym.mrgym.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrgym.mrgym.Dto.AsistenciaDto;
import com.mrgym.mrgym.Mapper.AsistenciaMapper;
import com.mrgym.mrgym.Models.AsistenciaEntity;
import com.mrgym.mrgym.Models.ClienteEntity;
import com.mrgym.mrgym.Models.EmpleadoEntity;
import com.mrgym.mrgym.Repositories.AsistenciaRepo;
import com.mrgym.mrgym.Repositories.ClienteRepo;
import com.mrgym.mrgym.Repositories.EmpleadoRepo;

@Service
public class AsistenciaService {

    @Autowired
    private AsistenciaRepo asistenciaRepo;

    @Autowired
    private ClienteRepo clienteRepo;

    @Autowired
    private EmpleadoRepo empleadoRepo;

    
    public AsistenciaEntity createAsistencia(AsistenciaDto asistenciaDTO) {
        // Buscar el cliente y empleado por su ID
        ClienteEntity cliente = clienteRepo.findById(asistenciaDTO.getFk_cliente_asistencia())
                                           .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        EmpleadoEntity empleado = empleadoRepo.findById(asistenciaDTO.getFk_empleado_asistencia())
                                              .orElseThrow(() -> new RuntimeException("Empleado no encontrado"));

        
        AsistenciaEntity asistenciaEntity = AsistenciaMapper.toAsistenciaEntity(asistenciaDTO);
        
        
        asistenciaEntity.setClienteEntities(cliente);
        asistenciaEntity.setEmpleadoEntity(empleado);

        
        return asistenciaRepo.save(asistenciaEntity);
    }
}
