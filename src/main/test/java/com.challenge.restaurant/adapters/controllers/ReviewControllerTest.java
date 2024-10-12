package com.challenge.restaurant.adapters.controller;

import com.challenge.restaurant.domain.entity.Review;
import com.challenge.restaurant.domain.service.ReviewService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(ReviewController.class)
public class ReviewControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private ReviewService reviewService;

    @BeforeEach
    public void setup() {
        reviewService = Mockito.mock(ReviewService.class);
    }

    @Test
    public void testAddReview() throws Exception {
        Review review = new Review(null, null, 5, "Excelente!", null);
        when(reviewService.addReview(any(Review.class))).thenReturn(review);

        mockMvc.perform(post("/avaliacoes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"note\":5,\"comment\":\"Excelente!\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.comment").value("Excelente!"));
    }

    @Test
    public void testGetReviewByRestaurant() throws Exception {
        Review review = new Review(null, null, 5, "Ótimo!", null);
        when(reviewService.getReviewByRestaurant(1L)).thenReturn(Collections.singletonList(review));

        mockMvc.perform(get("/avaliacoes/restaurant/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].comment").value("Ótimo!"));
    }
}