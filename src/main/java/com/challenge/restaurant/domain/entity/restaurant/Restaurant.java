package com.challenge.restaurant.domain.entity.restaurant;

import com.challenge.restaurant.domain.entity.restaurant.validation.RestaurantValidation;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class Restaurant {

    private Long id;
    private String name;
    private String cnpj;
    private String location;
    private String cuisineType;
    private Integer capacity;
    private String openingHours;

    public Restaurant(Long id, String name, String cnpj, String location, String cuisineType, Integer capacity, String openingHours){
        this.id = id;
        this.name = name;
        this.cnpj = cnpj;
        this.location = location;
        this.cuisineType = cuisineType;
        this.capacity = capacity;
        this.openingHours = openingHours;
    }

    public Restaurant createRestaurant() throws Exception{
        Restaurant restaurant = new RestaurantValidation().restaurantValidation(this);
        this.setId(getId());
        return restaurant;
    }

}
