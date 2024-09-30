package com.mrgym.mrgym.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrgym.mrgym.Models.ClienteEntity;
import com.mrgym.mrgym.Repositories.ClienteRepo;
import java.util.List;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepo clienteRepo;

    //mostrar a los clientes
    public List<ClienteEntity> getAllCLientes(){
        return clienteRepo.findAll();
    }

    //crear un cliente
    public ClienteEntity createCliente(ClienteEntity clienteEntity){
        return clienteRepo.save(clienteEntity);
    }

    //editar un cliente - Hay duas ...
    public ClienteEntity updateCliente(ClienteEntity clienteEntity){
        return clienteRepo.save(clienteEntity);
    }

    //eliminar un cliente
    public void deleteCliente(Long id){
        clienteRepo.deleteById(id);
    }
}
