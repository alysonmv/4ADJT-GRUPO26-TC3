package com.challenge.restaurant.domain.gateway.restaurant;

import com.challenge.restaurant.domain.entity.restaurant.Restaurant;

public interface CreateRestaurantInterface {

    Restaurant findRestaurantByCnpj(String cnpj);

    Restaurant createRestaurant(Restaurant restaurant);

}
