package com.challenge.restaurant.application.controller.review.request;

public record ReviewRequest(Long restaurantId, Long userId, Integer rating, String comment) {
}
