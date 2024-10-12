package com.challenge.restaurant.domain.useCase.restaurant;

import com.challenge.restaurant.domain.entity.restaurant.Restaurant;
import com.challenge.restaurant.domain.exception.restaurant.NotNullLocationException;
import com.challenge.restaurant.domain.exception.restaurant.NotNullNameException;
import com.challenge.restaurant.domain.gateway.restaurant.CreateRestaurantInterface;
import com.challenge.restaurant.domain.generic.OutputError;
import com.challenge.restaurant.domain.generic.OutputInterface;
import com.challenge.restaurant.domain.input.RestaurantInput;
import com.challenge.restaurant.domain.output.restaurant.CreateRestaurantOutput;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CreateRestaurantUseCase {

    private final CreateRestaurantInterface createRestaurantInterface;
    private OutputInterface createRestaurantOutputInterface;

    public void create (RestaurantInput restaurantInput) throws Exception {
        Restaurant restaurant = new Restaurant(
                null,
                restaurantInput.getName(),
                restaurantInput.getCpnj(),
                restaurantInput.getLocation(),
                restaurantInput.getCuisineType(),
                restaurantInput.getCapacity(),
                restaurantInput.getOpeningHours()
        );
        try {
            Restaurant searchRestaurant = this.createRestaurantInterface.findRestaurantByCnpj(restaurant.getCnpj());
            if (searchRestaurant == null) {
                restaurant = restaurant.createRestaurant();
                Restaurant restaurantEntity = this.createRestaurantInterface.createRestaurant(restaurant);
                this.createRestaurantOutputInterface = new CreateRestaurantOutput(restaurantEntity);
                return;
            }
            this.createRestaurantOutputInterface = new CreateRestaurantOutput(searchRestaurant);

        } catch (NotNullNameException | NotNullLocationException validationException) {
            this.createRestaurantOutputInterface = new OutputError(validationException.getMessage());

        } catch (Exception e) {
            this.createRestaurantOutputInterface = new OutputError(e.getMessage());
        }
    }
}

