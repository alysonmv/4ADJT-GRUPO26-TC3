package com.challenge.restaurant.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(RestaurantController.class)
public class RestaurantControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetRestaurant() throws Exception {
        mockMvc.perform(get("/restaurants/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Pasta Place"));
    }

    @Test
    public void testCreateRestaurant() throws Exception {
        String restaurantJson = "{\"name\":\"Pizza Place\",\"location\":\"Downtown\",\"cuisineType\":\"Italian\"}";

        mockMvc.perform(post("/restaurants")
                        .contentType("application/json")
                        .content(restaurantJson))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("Pizza Place"));
    }
}
