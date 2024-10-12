package com.challenge.restaurant.infra.adapter.repository;

import com.challenge.restaurant.domain.entity.restaurant.Restaurant;
import com.challenge.restaurant.domain.gateway.restaurant.SearchRestaurantInterface;
import com.challenge.restaurant.infra.model.RestaurantModel;
import com.challenge.restaurant.infra.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class SearchRestaurantRepository implements SearchRestaurantInterface {

    private final RestaurantRepository restaurantRepository;

    @Override
    public List<Restaurant> searchRestaurants(String name, String location, String cuisineType) {
        List<RestaurantModel> restaurantModels = restaurantRepository.findByNameAndLocationAndCuisineType(name, location, cuisineType);
        return restaurantModels.stream()
                .map(model -> new Restaurant(
                        model.getId(),
                        model.getCnpj(),
                        model.getName(),
                        model.getLocation(),
                        model.getCuisineType(),
                        model.getCapacity(),
                        model.getOpeningHours()
                )).collect(Collectors.toList());
    }
}
