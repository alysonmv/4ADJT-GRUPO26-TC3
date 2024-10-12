package com.challenge.restaurant.domain.present.restaurant.search;

import com.challenge.restaurant.domain.entity.restaurant.Restaurant;
import com.challenge.restaurant.domain.generic.OutputInterface;
import com.challenge.restaurant.domain.generic.presenter.PresenterInterface;
import com.challenge.restaurant.domain.output.restaurant.RestaurantSearchOutput;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestaurantSearchPresenter implements PresenterInterface {

    private final RestaurantSearchOutput restaurantSearchOutput;

    public RestaurantSearchPresenter(RestaurantSearchOutput restaurantSearchOutput) {
        this.restaurantSearchOutput = restaurantSearchOutput;
    }

    @Override
    public Map<String, Object> toArray() {
        List<Restaurant> restaurants = restaurantSearchOutput.getRestaurants();
        Map<String, Object> result = new HashMap<>();
        result.put("restaurants", restaurants);
        return result;
    }

    @Override
    public OutputInterface getOutput() {
        return this.restaurantSearchOutput;
    }
}
