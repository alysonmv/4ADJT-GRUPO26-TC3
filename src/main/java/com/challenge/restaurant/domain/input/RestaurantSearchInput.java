package com.challenge.restaurant.domain.input;

import lombok.Data;

@Data
public class RestaurantSearchInput {
    private String name;
    private String location;
    private String cuisineType;

    public RestaurantSearchInput(String name, String location, String cuisineType) {
        this.name = name;
        this.location = location;
        this.cuisineType = cuisineType;
    }
}
