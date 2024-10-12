package com.challenge.restaurant.infra.adapter.repository;

import com.challenge.restaurant.domain.entity.reservation.Reservation;
import com.challenge.restaurant.domain.gateway.reservation.CreateReservationInterface;
import com.challenge.restaurant.infra.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateReservationRepository implements CreateReservationInterface {

    private final ReservationRepository reservationRepository;

    @Override
    public Reservation createReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }
}
