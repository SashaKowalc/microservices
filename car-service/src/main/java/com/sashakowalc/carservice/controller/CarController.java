package com.sashakowalc.carservice.controller;

import com.sashakowalc.carservice.entities.CarEntity;
import com.sashakowalc.carservice.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping
    public ResponseEntity<List<CarEntity>> getCars() {
        List<CarEntity> cars = carService.getAll();
        if(cars.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(cars);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarEntity> getCarById(@PathVariable("id") int id) {
        CarEntity car = carService.getCarById(id);
        if (car == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(car);
    }

    @PostMapping
    public ResponseEntity<CarEntity> saveCar(@RequestBody CarEntity car) {
        CarEntity newCar = carService.saveCar(car);
        return ResponseEntity.ok(newCar);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<CarEntity>> getByUserId(@PathVariable("userId") int userId) {
        List<CarEntity> cars = carService.getByUserId(userId);
        if (cars == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(cars);
    }





}
