package com.challenge.restaurant.domain.entity.restaurant.validation;

import com.challenge.restaurant.domain.entity.restaurant.Restaurant;
import com.challenge.restaurant.domain.exception.restaurant.NotNullLocationException;
import com.challenge.restaurant.domain.exception.restaurant.NotNullNameException;

public class RestaurantValidation {

    public Restaurant restaurantValidation(Restaurant restaurant) throws Exception {
        if (restaurant.getCnpj().isEmpty()){
            return restaurant;
        }

        if (restaurant.getName().isEmpty()){
            throw new NotNullNameException("The name of the restaurant can not be null");
        }

        if(restaurant.getLocation().isEmpty()){
            throw new NotNullLocationException("The location of the restaurant can not be null");
        }

        return new Restaurant(null, restaurant.getName(), restaurant.getCnpj(), restaurant.getLocation(), restaurant.getCuisineType(), restaurant.getCapacity(), restaurant.getOpeningHours());
    }
}
