package com.challenge.restaurant.domain.output.reservation;

import com.challenge.restaurant.domain.entity.reservation.Reservation;
import com.challenge.restaurant.domain.generic.OutputInterface;
import com.challenge.restaurant.domain.generic.output.OutputStatus;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Data
@RequiredArgsConstructor
@Getter
@Setter
public class CreateReservationOutput implements OutputInterface {

    private Reservation reservation;

    public CreateReservationOutput(Reservation reservationEntity) {
        this.reservation = reservationEntity;
    }

    @Override
    public Object getBody() {
        return this.reservation;
    }

    @Override
    public OutputStatus getOutputStatus() {
        return null;
    }
}
