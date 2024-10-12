package com.challenge.restaurant.domain.gateway.restaurant;

import com.challenge.restaurant.domain.entity.restaurant.Restaurant;

import java.util.List;

public interface SearchRestaurantInterface {
    List<Restaurant> searchRestaurants(String name, String location, String cuisineType);
}
