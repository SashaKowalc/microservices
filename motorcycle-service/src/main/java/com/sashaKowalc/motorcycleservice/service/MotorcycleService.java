package com.sashaKowalc.motorcycleservice.service;

import com.sashaKowalc.motorcycleservice.entity.MotorcycleEntity;
import com.sashaKowalc.motorcycleservice.repository.MotorcycleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotorcycleService {

    @Autowired
    private MotorcycleRepository motorcycleRepository;

    public List<MotorcycleEntity> getAll() {
        return motorcycleRepository.findAll();
    }

    public MotorcycleEntity getMotorcycleById(int id) {
        return motorcycleRepository.findById(id).orElse(null);
    }

    public MotorcycleEntity save(MotorcycleEntity motorcycle) {
        return motorcycleRepository.save(motorcycle);
    }

    public List<MotorcycleEntity> getByUserId(int userId) {
        return motorcycleRepository.findByUserId(userId);
    }

}
