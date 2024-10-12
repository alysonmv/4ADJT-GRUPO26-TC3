package com.challenge.restaurant.domain.useCase.reservation;

import com.challenge.restaurant.domain.entity.reservation.Reservation;
import com.challenge.restaurant.domain.gateway.reservation.CreateReservationInterface;
import com.challenge.restaurant.domain.generic.OutputError;
import com.challenge.restaurant.domain.generic.OutputInterface;
import com.challenge.restaurant.domain.input.ReservationInput;
import com.challenge.restaurant.domain.output.reservation.CreateReservationOutput;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CreateReservationUseCase {

    private final CreateReservationInterface createReservationInterface;
    private OutputInterface createReservationOutputInterface;

    public void create(ReservationInput reservationInput) throws Exception {
        Reservation reservation = new Reservation(
                null,
                reservationInput.getRestaurantId(),
                reservationInput.getCustomerName(),
                reservationInput.getReservationDate(),
                reservationInput.getReservationTime(),
                reservationInput.getNumberOfGuests(),
                "Pending"
        );
        try {
            reservation = reservation.createReservation();
            Reservation reservationEntity = this.createReservationInterface.createReservation(reservation);
            this.createReservationOutputInterface = new CreateReservationOutput(reservationEntity);

        } catch (Exception e) {
            this.createReservationOutputInterface = new OutputError(e.getMessage());
        }
    }
}
