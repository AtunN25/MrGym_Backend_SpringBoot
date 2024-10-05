package com.mrgym.mrgym.Repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mrgym.mrgym.Models.EmpleadoEntity;



public interface EmpleadoRepo extends JpaRepository<EmpleadoEntity,Long>{

    //en este caso metodos mas especificos 
    //Optional<EmpleadoEntity> findByUsuario_empleado(String usuario_empleado);

    @Query("SELECT e FROM EmpleadoEntity e WHERE e.usuario_empleado = :usuarioEmpleado")
     Optional<EmpleadoEntity> findByUsuarioEmpleado(@Param("usuarioEmpleado") String usuario);

}
