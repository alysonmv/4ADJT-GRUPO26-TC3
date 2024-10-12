package com.challenge.restaurant.domain.input;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Getter
@Setter
public class ReservationInput {

    private Long restaurantId;
    private String customerName;
    private LocalDate reservationDate;
    private LocalTime reservationTime;
    private Integer numberOfGuests;

    public ReservationInput(Long restaurantId, String customerName, LocalDate reservationDate, LocalTime reservationTime, Integer numberOfGuests) {
        this.restaurantId = restaurantId;
        this.customerName = customerName;
        this.reservationDate = reservationDate;
        this.reservationTime = reservationTime;
        this.numberOfGuests = numberOfGuests;
    }
}
