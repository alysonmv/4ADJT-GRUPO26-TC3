package com.challenge.restaurant.domain.input;

import lombok.Data;

@Data
public class ReviewInput {
    private Long restaurantId;
    private Long userId;
    private Integer rating;
    private String comment;

    public ReviewInput(Long restaurantId, Long userId, Integer rating, String comment) {
        this.restaurantId = restaurantId;
        this.userId = userId;
        this.rating = rating;
        this.comment = comment;
    }
}
