package com.challenge.restaurant.service;

import com.challenge.restaurant.domain.entity.Restaurant;
import com.challenge.restaurant.infra.repository.RestaurantRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

public class RestaurantServiceTest {

    @InjectMocks
    private RestaurantService restaurantService;

    @Mock
    private RestaurantRepository restaurantRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testRegisterRestaurant() {
        Restaurant restaurant = new Restaurant("Sushi Spot", "Uptown", "Japanese");
        when(restaurantRepository.save(any(Restaurant.class))).thenReturn(restaurant);

        Restaurant createdRestaurant = restaurantService.registerRestaurant(restaurant);
        assertNotNull(createdRestaurant);
        assertEquals("Sushi Spot", createdRestaurant.getName());
    }
}
