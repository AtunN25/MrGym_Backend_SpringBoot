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
    public ClienteEntity guardarCliente(ClienteEntity clienteEntity){
        return clienteRepo.save(clienteEntity);
    }

    //editar un cliente - luego se podra manejar exactametne que campos se pueden actualizar y otros no
    public ClienteEntity updateCliente(Long id,ClienteEntity clienteDetails){
        ClienteEntity cliente = clienteRepo.findById(id).orElseThrow();
        cliente.setNombre_cliente(clienteDetails.getNombre_cliente());
        cliente.setApellido_cliente(clienteDetails.getApellido_cliente());
        cliente.setDni_cliente(clienteDetails.getDni_cliente());
        cliente.setEmail(clienteDetails.getEmail());
        cliente.setTelefono_cliente(clienteDetails.getTelefono_cliente());
        cliente.setMiembro(clienteDetails.getMiembro());

        return clienteRepo.save(cliente);
    }

    //eliminar un cliente
    public void deleteCliente(Long id){
        clienteRepo.deleteById(id);
    }

    
}
