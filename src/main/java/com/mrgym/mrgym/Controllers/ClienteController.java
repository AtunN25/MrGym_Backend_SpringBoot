package com.mrgym.mrgym.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mrgym.mrgym.Models.ClienteEntity;
import com.mrgym.mrgym.Services.ClienteService;

import lombok.RequiredArgsConstructor;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cliente")
@RequiredArgsConstructor
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/listar")
   private List<ClienteEntity> listCLientes(){
        return clienteService.getAllCLientes();
   }

   @PostMapping("/agregar")
   private ClienteEntity agregarCliente(@RequestBody ClienteEntity clienteEntity){
          return clienteService.guardarCliente(clienteEntity);
   }

   @PutMapping("/actualizar/{id}")
   private ClienteEntity actualizarCliente(@PathVariable Long id,@RequestBody ClienteEntity clienteEntity){
          return clienteService.updateCliente(id, clienteEntity);
   }

   @GetMapping("/buscar/{dniCliente}")
   public ResponseEntity<ClienteEntity> buscarClientePorDni(@PathVariable String dniCliente) {
        Optional<ClienteEntity> cliente = clienteService.findByDniCliente(dniCliente);
        if (cliente.isPresent()) {
            return ResponseEntity.ok(cliente.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    

}
