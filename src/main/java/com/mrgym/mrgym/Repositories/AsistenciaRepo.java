package com.mrgym.mrgym.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mrgym.mrgym.Models.AsistenciaEntity;

public interface AsistenciaRepo extends JpaRepository<AsistenciaEntity, Long> {
    
}
