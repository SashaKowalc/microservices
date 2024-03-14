package com.sashaKowalc.motorcycleservice.repository;

import com.sashaKowalc.motorcycleservice.entity.MotorcycleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MotorcycleRepository extends JpaRepository<MotorcycleEntity, Integer> {

    List<MotorcycleEntity> findByUserId(int userId);
}
