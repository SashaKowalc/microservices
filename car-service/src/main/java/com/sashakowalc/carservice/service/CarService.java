package com.sashakowalc.carservice.service;

import com.sashakowalc.carservice.entities.CarEntity;
import com.sashakowalc.carservice.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public List<CarEntity> getAll() {
        return carRepository.findAll();
    }

    public CarEntity getCarById(int id) {
        return carRepository.findById(id).orElse(null);
    }

    public CarEntity saveCar(CarEntity car) {
        return carRepository.save(car);
    }

    public List<CarEntity> getByUserId(int userId) {
        return carRepository.findByUserId(userId);
    }

}
