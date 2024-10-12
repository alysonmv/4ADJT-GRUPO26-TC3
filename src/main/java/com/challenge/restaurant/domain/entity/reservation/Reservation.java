package com.challenge.restaurant.domain.entity.reservation;

import lombok.*;

import java.time.*;

@Getter
@Setter
@NoArgsConstructor
public class Reservation {

    private Long id;
    private Long restaurantId;
    private String customerName;
    private LocalDate reservationDate;
    private LocalTime reservationTime;
    private Integer numberOfGuests;
    private String status;

    public Reservation(Long id, Long restaurantId, String customerName, LocalDate reservationDate, LocalTime reservationTime, Integer numberOfGuests, String status) {
        this.id = id;
        this.restaurantId = restaurantId;
        this.customerName = customerName;
        this.reservationDate = reservationDate;
        this.reservationTime = reservationTime;
        this.numberOfGuests = numberOfGuests;
        this.status = status;
    }

    public Reservation createReservation() throws Exception {
        this.setStatus("Pending");
        return this;
    }
}
