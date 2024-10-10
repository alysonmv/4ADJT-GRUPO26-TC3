package com.challenge.restaurant.repository;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;

@DataJdbcTest
public class RestaurantRepositoryTest {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Test
    public void testFindByName() {
        Restaurant restaurant = new Restaurant("Burger Joint", "Suburb", "American");
        restaurantRepository.save(restaurant);

        Restaurant foundRestaurant = restaurantRepository.findByName("Burger Joint");
        assertThat(foundRestaurant).isNotNull();
        assertThat(foundRestaurant.getLocation()).isEqualTo("Suburb");
    }
}
