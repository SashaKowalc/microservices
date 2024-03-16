package com.sashakowalc.service.models;

public class Motorcycle {
    private String brand;
    private String model;
    private Integer userId;

    public Motorcycle() {
        super();
    }

    public String getBrand() {
        return brand;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
