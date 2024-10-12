package com.challenge.restaurant.domain.entity.review;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Review {
    private Long id;
    private Long restaurantId;
    private Long userId;
    private Integer rating;
    private String comment;

    public Review(Long id, Long restaurantId, Long userId, Integer rating, String comment) {
        this.id = id;
        this.restaurantId = restaurantId;
        this.userId = userId;
        this.rating = rating;
        this.comment = comment;
    }

    public Review createReview() {
        return this;
    }
}
