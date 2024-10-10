package com.challenge.restaurant.domain.repository;

import com.challenge.restaurant.domain.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    List<Restaurant> findByNameContainingIgnoreCase(String name);
    List<Restaurant> findByLocationContainingIgnoreCase(String location);
    List<Restaurant> findByCuisineTypeContainingIgnoreCase(String cuisineType);
}
