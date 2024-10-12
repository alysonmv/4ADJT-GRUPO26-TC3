package com.challenge.restaurant.domain.present.restaurant.create;

import com.challenge.restaurant.domain.generic.presenter.PresenterInterface;
import com.challenge.restaurant.domain.output.restaurant.CreateRestaurantOutput;

import java.util.HashMap;
import java.util.Map;

public class IndentifyRestaurantPresenter implements PresenterInterface {
    private final CreateRestaurantOutput createRestaurantOutput;

    public IndentifyRestaurantPresenter(CreateRestaurantOutput createRestaurantOutput) {
        this.createRestaurantOutput = createRestaurantOutput;
    }

    public Map<String, Object> toArray() {
        Map<String, Object> restaurant = new HashMap<>();
        restaurant.put("name", this.createRestaurantOutput.getRestaurant().getName());
        restaurant.put("cnpj", this.createRestaurantOutput.getRestaurant().getCnpj());
        restaurant.put("location", this.createRestaurantOutput.getRestaurant().getLocation());
        restaurant.put("type", this.createRestaurantOutput.getRestaurant().getCuisineType());
        restaurant.put("capacity", this.createRestaurantOutput.getRestaurant().getCapacity().toString());
        restaurant.put("id", this.createRestaurantOutput.getRestaurant().getId().toString());
        return restaurant;
    }

    public CreateRestaurantOutput getOutput() {
        return this.createRestaurantOutput;
    }
}
