package com.challenge.restaurant.domain.present.reservation.create;

import com.challenge.restaurant.domain.generic.presenter.PresenterInterface;
import com.challenge.restaurant.domain.output.reservation.CreateReservationOutput;

import java.util.HashMap;
import java.util.Map;

public class IndentifyReservationPresenter implements PresenterInterface {

    private final CreateReservationOutput createReservationOutput;

    public IndentifyReservationPresenter(CreateReservationOutput createReservationOutput) {
        this.createReservationOutput = createReservationOutput;
    }

    public Map<String, Object> toArray() {
        Map<String, Object> reservation = new HashMap<>();
        reservation.put("restaurantId", this.createReservationOutput.getReservation().getRestaurantId());
        reservation.put("customerName", this.createReservationOutput.getReservation().getCustomerName());
        reservation.put("reservationDate", this.createReservationOutput.getReservation().getReservationDate());
        reservation.put("reservationTime", this.createReservationOutput.getReservation().getReservationTime());
        reservation.put("numberOfGuests", this.createReservationOutput.getReservation().getNumberOfGuests().toString());
        reservation.put("status", this.createReservationOutput.getReservation().getStatus());
        reservation.put("id", this.createReservationOutput.getReservation().getId().toString());
        return reservation;
    }

    public CreateReservationOutput getOutput() {
        return this.createReservationOutput;
    }
}
