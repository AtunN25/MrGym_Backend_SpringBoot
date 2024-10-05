package com.mrgym.mrgym.Demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mrgym.mrgym.Models.ClienteEntity;
import com.mrgym.mrgym.Services.ClienteService;

import lombok.RequiredArgsConstructor;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
//ruta extra para comprobar los puntos seguros
public class DemoController {

    @PostMapping(value = "demo")
    public String welcome(){
        return "welcome fomr secure endpoint";
    }

    @Autowired
    private ClienteService clienteService;

    @GetMapping(value = "listarc")
   private List<ClienteEntity> listCLientes(){
        return clienteService.getAllCLientes();
   }

    
}
