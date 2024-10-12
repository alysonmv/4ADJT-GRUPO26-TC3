package com.challenge.restaurant.application.controller.restaurant.request;

public record RestaurantRequest (String name, String cnpj, String location, String cuisineType, Integer capacity, String openingHours) {
}
