package com.sashakowalc.service.service;

import com.sashakowalc.service.entities.UserEntity;
import com.sashakowalc.service.feignclients.CarFeignClient;
import com.sashakowalc.service.feignclients.MotorcycleFeignClient;
import com.sashakowalc.service.models.Car;
import com.sashakowalc.service.models.Motorcycle;
import com.sashakowalc.service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CarFeignClient carFeignClient;

    @Autowired
    private MotorcycleFeignClient motorcycleFeignClient;


    public List<Car> getCarList(int userId) {
        return restTemplate.getForObject("http://localhost:8002/car/user/" + userId, List.class);
    }

    public List<Motorcycle> getMotorcycleList(int userId) {
        return restTemplate.getForObject("http://localhost:8003/motorcycle/user/" + userId, List.class);
    }

    public Car saveCar(int userId, Car car) {
        car.setUserId(userId);
        return carFeignClient.save(car);
    }

    public Motorcycle saveMotorcycle(int userId, Motorcycle motorcycle) {
        motorcycle.setUserId(userId);
        return motorcycleFeignClient.save(motorcycle);
    }

    public Map<String, Object> getUserAndVehicles(int userId) {
        Map<String, Object> result = new HashMap<>();
        UserEntity user = userRepository.findById(userId).orElse(null);
        if(user == null) {
            result.put("Message", "User does not exist");
            return result;
        }
        result.put("User", user);

        List<Car> cars = carFeignClient.getCars(userId);
        if(cars == null || cars.isEmpty()){
            result.put("Cars", "The user has no cars");
        } else {
            result.put("Cars", cars);
        }

        List<Motorcycle> motorcycles = motorcycleFeignClient.getMotorcycle(userId);
        if(motorcycles == null || motorcycles.isEmpty()){
            result.put("Motorcycles", "The user has no motorcycles");
        } else {
            result.put("Motorcycles", motorcycles);
        }

        return result;
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
