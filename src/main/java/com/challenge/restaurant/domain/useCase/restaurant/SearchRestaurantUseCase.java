package com.challenge.restaurant.domain.useCase.restaurant;

import com.challenge.restaurant.domain.entity.restaurant.Restaurant;
import com.challenge.restaurant.domain.gateway.restaurant.SearchRestaurantInterface;
import com.challenge.restaurant.domain.generic.OutputError;
import com.challenge.restaurant.domain.generic.OutputInterface;
import com.challenge.restaurant.domain.input.RestaurantSearchInput;
import com.challenge.restaurant.domain.output.restaurant.RestaurantSearchOutput;
import lombok.Getter;

import java.util.List;

@Getter
public class SearchRestaurantUseCase {

    private final SearchRestaurantInterface searchRestaurantInterface;
    private OutputInterface restaurantSearchOutput;

    public SearchRestaurantUseCase(SearchRestaurantInterface searchRestaurantInterface) {
        this.searchRestaurantInterface = searchRestaurantInterface;
    }

    public void search(RestaurantSearchInput searchInput) {
        try {
            List<Restaurant> restaurants = this.searchRestaurantInterface.searchRestaurants(
                    searchInput.getName(),
                    searchInput.getLocation(),
                    searchInput.getCuisineType()
            );

            this.restaurantSearchOutput = new RestaurantSearchOutput(restaurants);

        } catch (Exception e) {
            this.restaurantSearchOutput = new OutputError(e.getMessage());
        }
    }
}
