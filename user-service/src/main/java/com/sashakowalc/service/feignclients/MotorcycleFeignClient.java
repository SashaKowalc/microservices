package com.sashakowalc.service.feignclients;

import com.sashakowalc.service.models.Car;
import com.sashakowalc.service.models.Motorcycle;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "motorcycle-service", url = "http://localhost:8003")
@RequestMapping("/motorcycle")
public interface MotorcycleFeignClient {

    @GetMapping("/user/{userId}")
    public List<Motorcycle> getMotorcycle(@PathVariable("userId") int userId);

    @PostMapping
    public Motorcycle save(@RequestBody Motorcycle motorcycle);

}
