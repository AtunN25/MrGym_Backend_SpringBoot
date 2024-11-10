package com.mrgym.mrgym.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mrgym.mrgym.Models.ClienteEntity;


import java.util.Optional;


public interface ClienteRepo extends JpaRepository<ClienteEntity,Long>{

     @Query("SELECT e FROM ClienteEntity e WHERE e.dni_cliente = :dniCliente")
     Optional<ClienteEntity> findByDniCliente(@Param("dniCliente") String dniCliente);

}
