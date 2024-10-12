package com.challenge.restaurant.domain.input;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class RestaurantInput {
    private String name;
    private String cpnj;
    private String location;
    private String cuisineType;
    private Integer capacity;
    private String openingHours;

    public RestaurantInput(String name, String cpnj, String location, String cuisineType, Integer capacity, String openingHours){
        this.name = name;
        this.cnpj = cpnj,
        this.location = location;
        this.cuisineType = cuisineType;
        this.capacity = capacity;
        this.openingHours = openingHours;
    }
}
