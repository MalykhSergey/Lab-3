package com.example.lab3;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Car implements Serializable {
    private final String modelName;
    private final String brandName;
    private final int year;
    private final int maxSpeed;
    private final float capacity;
    private final int price;

    @JsonCreator
    public Car(
            @JsonProperty("modelName") String modelName,
            @JsonProperty("brandName") String brandName,
            @JsonProperty("year") int year,
            @JsonProperty("maxSpeed") int maxSpeed,
            @JsonProperty("capacity") float capacity,
            @JsonProperty("price") int price) {
        this.modelName = modelName;
        this.brandName = brandName;
        this.year = year;
        this.maxSpeed = maxSpeed;
        this.capacity = capacity;
        this.price = price;
    }

    public String getModelName() {
        return modelName;
    }

    public String getBrandName() {
        return brandName;
    }

    public int getYear() {
        return year;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public float getCapacity() {
        return capacity;
    }

    public int getPrice() {
        return price;
    }
}
