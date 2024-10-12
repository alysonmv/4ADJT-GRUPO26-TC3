package com.challenge.restaurant.infra.repository;

import com.challenge.restaurant.domain.entity.restaurant.Restaurant;
import com.challenge.restaurant.infra.model.RestaurantModel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RestaurantRepository extends JpaRepository<RestaurantModel, Long> {

    RestaurantModel findByCnpj(String cnpj);

    List<RestaurantModel> findByNameContainingIgnoreCase(String name);

    List<Restaurant> findByLocationContainingIgnoreCase(String location);

    List<Restaurant> findByCuisineTypeContainingIgnoreCase(String cuisineType);
    List<RestaurantModel> findByNameAndLocationAndCuisineType(String name, String location, String cuisineType);
}
