package com.mrgym.mrgym.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrgym.mrgym.Dto.MembresiaDto;
import com.mrgym.mrgym.Models.ClienteEntity;
import com.mrgym.mrgym.Models.MembresiaEntity;
import com.mrgym.mrgym.Models.PromocionEntity;
import com.mrgym.mrgym.Repositories.ClienteRepo;
import com.mrgym.mrgym.Repositories.MembresiaRepo;
import com.mrgym.mrgym.Repositories.PromocionRepo;
import com.mrgym.mrgym.Mapper.MembresiaMapper;

@Service
public class MembresiaService {
    @Autowired
    private MembresiaRepo membresiaRepo;

    @Autowired
    private ClienteRepo clienteRepo;
    
    @Autowired
    private PromocionRepo promocionRepo;


    public List<MembresiaEntity> getAllMembresia(){
        return membresiaRepo.findAll();
    }

    public MembresiaDto createMembresia(MembresiaDto membresiaDTO) {
        // Verificar si los datos de cliente y promoción son válidos
        ClienteEntity cliente = clienteRepo.findById(membresiaDTO.getFk_cliente_membresia())
                                           .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        
        PromocionEntity promocion = promocionRepo.findById(membresiaDTO.getFk_promocion())
                                                 .orElseThrow(() -> new RuntimeException("Promoción no encontrada"));

        // Crear la nueva entidad Membresia
        MembresiaEntity membresiaEntity = new MembresiaEntity();
        membresiaEntity.setFecha_inicio(membresiaDTO.getFecha_inicio());
        membresiaEntity.setFecha_final(membresiaDTO.getFecha_final());
        membresiaEntity.setDuracion_meses(membresiaDTO.getDuracion_meses());
        membresiaEntity.setCosto_mensual(membresiaDTO.getCosto_mensual());
        
        // Asignar las relaciones
        membresiaEntity.setClienteEntities(cliente);  // Asignar el cliente relacionado
        membresiaEntity.setPromocionEntities(promocion);  // Asignar la promoción relacionada

        // Guardar la membresía en la base de datos
        MembresiaEntity savedMembresia = membresiaRepo.save(membresiaEntity);
        
        // Convertir la entidad guardada en un DTO para devolverla de manera estática
        return MembresiaMapper.toMembresiaDTO(savedMembresia);
    }
}
