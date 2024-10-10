package com.challenge.restaurant.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(ReviewController.class)
public class ReviewControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetReview() throws Exception {
        mockMvc.perform(get("/reviews/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content").value("Great food!"));
    }

    @Test
    public void testCreateReview() throws Exception {
        String reviewJson = "{\"content\":\"Excellent service!\",\"rating\":5}";

        mockMvc.perform(post("/reviews")
                        .contentType("application/json")
                        .content(reviewJson))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.content").value("Excellent service!"));
    }
}
