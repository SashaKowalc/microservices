package com.sashakowalc.service.controller;

import com.sashakowalc.service.entities.UserEntity;
import com.sashakowalc.service.models.Car;
import com.sashakowalc.service.models.Motorcycle;
import com.sashakowalc.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserEntity>> getUsers() {
        List<UserEntity> userEntities = userService.getAll();
        if(userEntities.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(userEntities);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserEntity> getUser(@PathVariable("id") int id) {
        UserEntity userEntity = userService.getUserById(id);
        if(userEntity == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(userEntity);
    }

    @PostMapping
    public ResponseEntity<UserEntity> saveUser(@RequestBody UserEntity userEntity) {
        UserEntity newUserEntity = userService.save(userEntity);
        return ResponseEntity.ok(newUserEntity);
    }

    @GetMapping("/car/{userId}")
    public ResponseEntity<List<Car>> getCarList(@PathVariable("userId") int userId) {
        UserEntity user = userService.getUserById(userId);
        if(user == null) {
            ResponseEntity.notFound().build();
        }

        List<Car> cars = userService.getCarList(userId);
        return ResponseEntity.ok(cars);
    }

    @GetMapping("/motorcycle/{userId}")
    public ResponseEntity<List<Motorcycle>> getMotorcycleList(@PathVariable("userId") int userId) {
        UserEntity user = userService.getUserById(userId);
        if(user == null) {
            ResponseEntity.notFound().build();
        }

        List<Motorcycle> motorcycles = userService.getMotorcycleList(userId);
        return ResponseEntity.ok(motorcycles);
    }

    @PostMapping("/car/{userId}")
    public ResponseEntity<Car> saveCar(@PathVariable("userId") int userId, @RequestBody Car car) {
        Car newCar = userService.saveCar(userId, car);
        return ResponseEntity.ok(newCar);
    }

    @GetMapping("/all/{userId}")
    public ResponseEntity<Map<String, Object>> getAllVehiclesByUserId(@PathVariable("userId") int userId) {
        Map<String, Object> result = userService.getUserAndVehicles(userId);
        return ResponseEntity.ok(result);
    }


    @PostMapping("/motorcycle/{userId}")
    public ResponseEntity<Motorcycle> saveMotorcycle(@PathVariable("userId") int userId, @RequestBody Motorcycle motorcycle) {
        Motorcycle newMotorcycle = userService.saveMotorcycle(userId, motorcycle);
        return ResponseEntity.ok(newMotorcycle);
    }

}