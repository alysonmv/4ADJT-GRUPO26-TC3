package com.challenge.restaurant.domain.service;

import com.challenge.restaurant.domain.entity.reservation.Reservation;
import com.challenge.restaurant.infra.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public Reservation makeReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public List<Reservation> getReservationsByRestaurant(Long restaurantId) {
        return reservationRepository.findByRestaurantId(restaurantId);
    }

    public Reservation getReservationById(Long id) {
        return reservationRepository.findById(id).orElseThrow(() -> new RuntimeException("Reservation not found"));
    }

    public Reservation updateReservation(Long id, Reservation reservation) {
        Reservation existingReservation = getReservationById(id);
        existingReservation.setCustomerName(reservation.getCustomerName());
        existingReservation.setReservationDateTime(reservation.getReservationDateTime());
        existingReservation.setNumberOfGuests(reservation.getNumberOfGuests());
        return reservationRepository.save(existingReservation);
    }

    public void cancelReservation(Long id) {
        reservationRepository.deleteById(id);
    }
}
