package com.challenge.restaurant.domain.output.restaurant;

import com.challenge.restaurant.domain.entity.restaurant.Restaurant;
import com.challenge.restaurant.domain.generic.OutputInterface;
import com.challenge.restaurant.domain.generic.output.OutputStatus;
import lombok.Data;

import java.util.List;

@Data
public class RestaurantSearchOutput implements OutputInterface {

    private final List<Restaurant> restaurants;

    @Override
    public Object getBody() {
        return this.restaurants;
    }

    @Override
    public OutputStatus getOutputStatus() {
        return new OutputStatus(200, "OK", "Search completed successfully.");
    }
}
