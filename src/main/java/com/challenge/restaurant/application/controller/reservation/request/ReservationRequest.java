package com.challenge.restaurant.application.controller.reservation.request;

import java.time.LocalDate;
import java.time.LocalTime;

public record ReservationRequest(Long restaurantId, String customerName, LocalDate reservationDate, LocalTime reservationTime, Integer numberOfGuests) {
}
