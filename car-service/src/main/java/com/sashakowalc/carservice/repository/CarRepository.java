package com.sashakowalc.carservice.repository;

import com.sashakowalc.carservice.entities.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<CarEntity, Integer> {
    List<CarEntity> findByUserId(int userId);
}
