package com.mrgym.mrgym.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mrgym.mrgym.Models.CargoEntity;

public interface CargoRepo extends JpaRepository<CargoEntity,Long>{
    
}
