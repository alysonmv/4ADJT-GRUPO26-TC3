package com.challenge.restaurant.domain.gateway.reservation;

import com.challenge.restaurant.domain.entity.reservation.Reservation;

public interface CreateReservationInterface {

    Reservation createReservation(Reservation reservation);
}
