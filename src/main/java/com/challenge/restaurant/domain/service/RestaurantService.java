package com.challenge.restaurant.domain.service;

import com.challenge.restaurant.domain.entity.restaurant.Restaurant;
import com.challenge.restaurant.infra.repository.RestaurantRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public Restaurant registerRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    public List<Restaurant> searchRestaurantsByName(String name) {
        return restaurantRepository.findByNameContainingIgnoreCase(name);
    }

    public List<Restaurant> searchRestaurantsByLocation(String location) {
        return restaurantRepository.findByLocationContainingIgnoreCase(location);
    }

    public List<Restaurant> searchRestaurantsByCuisineType(String cuisineType) {
        return restaurantRepository.findByCuisineTypeContainingIgnoreCase(cuisineType);
    }

    public Restaurant getRestaurantById(Long id) {
        return restaurantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Restaurant not found"));
    }

    public Restaurant updateRestaurant(Long id, Restaurant restaurant) {
        restaurant.setId(id);
        return restaurantRepository.save(restaurant);
    }

    public void deleteRestaurant(Long id) {
        restaurantRepository.deleteById(id);
    }
}
