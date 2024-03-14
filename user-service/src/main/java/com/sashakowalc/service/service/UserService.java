package com.sashakowalc.service.service;

import com.sashakowalc.service.entities.UserEntity;
import com.sashakowalc.service.models.Car;
import com.sashakowalc.service.models.Motorcycle;
import com.sashakowalc.service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserRepository userRepository;

    public List<Car> getCarList(int userId) {
        return restTemplate.getForObject("http://localhost:8002/car/user/" + userId, List.class);
    }

    public List<Motorcycle> getMotorcycleList(int userId) {
        return restTemplate.getForObject("http://localhost:8003/motorcycle/user/" + userId, List.class);
    }

    public List<UserEntity> getAll() {
        return userRepository.findAll();
    }

    public UserEntity getUserById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    public UserEntity save(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }










}
