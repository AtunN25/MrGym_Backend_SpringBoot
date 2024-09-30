package com.mrgym.mrgym.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mrgym.mrgym.Models.ClienteEntity;
import com.mrgym.mrgym.Services.ClienteService;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;



@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/list")
   private List<ClienteEntity> listCLientes(){
        return clienteService.getAllCLientes();
   }

}
