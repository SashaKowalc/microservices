package com.sashaKowalc.motorcycleservice.controller;

import com.sashaKowalc.motorcycleservice.entity.MotorcycleEntity;
import com.sashaKowalc.motorcycleservice.service.MotorcycleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/motorcycle")
public class MotorcycleController {

    @Autowired
    private MotorcycleService motorcycleService;

    @GetMapping
    public ResponseEntity<List<MotorcycleEntity>> getMotorcycles() {
        List<MotorcycleEntity> motorcycles = motorcycleService.getAll();
        if(motorcycles.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(motorcycles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MotorcycleEntity> getMotorcycleById(@PathVariable int id) {
        MotorcycleEntity motorcycle = motorcycleService.getMotorcycleById(id);
        if (motorcycle == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(motorcycle);
    }

    @PostMapping
    public ResponseEntity<MotorcycleEntity> saveMotorcycle(@RequestBody MotorcycleEntity motorcycle) {
        MotorcycleEntity newMotorcycle = motorcycleService.save(motorcycle);
        return ResponseEntity.ok(newMotorcycle);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<MotorcycleEntity>> getMotorcycleByUserId(@PathVariable("userId") int userId) {
        List<MotorcycleEntity> motorcycles = motorcycleService.getByUserId(userId);
        if(motorcycles.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(motorcycles);
    }

}
