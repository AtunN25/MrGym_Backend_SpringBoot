package com.mrgym.mrgym.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mrgym.mrgym.Dto.MembresiaDto;
import com.mrgym.mrgym.Models.MembresiaEntity;
//import com.mrgym.mrgym.Models.MembresiaEntity;
import com.mrgym.mrgym.Services.MembresiaService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/membresia")
@RequiredArgsConstructor
public class MembresiaController {

    @Autowired
    public MembresiaService membresiaService;

     @GetMapping("/listar")
   private List<MembresiaEntity> listMemebresia(){
        return membresiaService.getAllMembresia();
   }

    @PostMapping("/registrar")
    public MembresiaDto AgregarMembresia(@RequestBody MembresiaDto membresiaDTO) {
        
        return membresiaService.createMembresia(membresiaDTO);
    }
    
    
}
