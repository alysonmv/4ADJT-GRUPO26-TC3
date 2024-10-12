package com.challenge.restaurant.domain.output.restaurant;

import com.challenge.restaurant.domain.entity.restaurant.Restaurant;
import com.challenge.restaurant.domain.generic.OutputInterface;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Data
@RequiredArgsConstructor
@Getter
@Setter
public class CreateRestaurantOutput implements OutputInterface {

    private Restaurant restaurant;

    public CreateRestaurantOutput(Restaurant restaurantEntity){
        this.restaurant = restaurantEntity;
    }

    @Override
    public Object getBody() {
        return this.restaurant;
    }
}
