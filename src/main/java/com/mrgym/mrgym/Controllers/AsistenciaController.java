package com.mrgym.mrgym.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mrgym.mrgym.Dto.AsistenciaDto;
import com.mrgym.mrgym.Mapper.AsistenciaMapper;
import com.mrgym.mrgym.Models.AsistenciaEntity;
import com.mrgym.mrgym.Services.AsistenciaService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/asistencia")
@RequiredArgsConstructor
public class AsistenciaController {

    @Autowired
    private AsistenciaService asistenciaService;

  
    @PostMapping("/registrar")
    public AsistenciaDto registrarAsistencia(@RequestBody AsistenciaDto asistenciaDTO) {
       
        AsistenciaEntity asistenciaEntity = asistenciaService.createAsistencia(asistenciaDTO);

        
        return AsistenciaMapper.toAsistenciaDTO(asistenciaEntity);
    }
}
