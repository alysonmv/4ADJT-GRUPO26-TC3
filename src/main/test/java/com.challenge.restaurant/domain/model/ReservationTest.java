package com.challenge.restaurant.domain.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReservationTest {

    @Test
    public void testReservationCreation() {
        Restaurant restaurant = new Restaurant(1L, "Restaurante Teste", "Rua Exemplo, 123", "Italiana", 50, "10:00-22:00");
        Reservation reservation = new Reservation(1L, restaurant, "Cliente Teste", LocalDateTime.now(), LocalDateTime.now().plusHours(2), 4);

        assertEquals(1L, reservation.getId());
        assertEquals(restaurant, reservation.getRestaurant());
        assertEquals("Cliente Teste", reservation.getCustomerName());
        assertEquals(4, reservation.getNumberOfGuests());
    }
}
