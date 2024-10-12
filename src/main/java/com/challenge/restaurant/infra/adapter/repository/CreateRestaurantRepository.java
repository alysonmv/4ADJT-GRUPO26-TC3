package com.challenge.restaurant.infra.adapter.repository;

import com.challenge.restaurant.domain.entity.restaurant.Restaurant;
import com.challenge.restaurant.domain.gateway.restaurant.CreateRestaurantInterface;
import com.challenge.restaurant.infra.model.RestaurantModel;
import com.challenge.restaurant.infra.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateRestaurantRepository implements CreateRestaurantInterface {

    private final RestaurantRepository restaurantRepository;

    public Restaurant findRestaurantByCnpj(String cnpj) {
        RestaurantModel restaurantModel = this.restaurantRepository.findByCnpj(cnpj);
        if(restaurantModel == null){
            return null;
        }
        return new Restaurant (restaurantModel.getId(), restaurantModel.getName(), restaurantModel.getCnpj(),
                restaurantModel.getLocation(), restaurantModel.getCuisineType(), restaurantModel.getCapacity(), restaurantModel.getOpeningHours());
    }
}
