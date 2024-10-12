package com.challenge.restaurant.infra.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "reservations")
public class ReservationModel {

    @Id
    private Long id;

    private Long restaurantId;

    private String customerName;

    private LocalDate reservationDate;
    private LocalTime reservationTime;
    private int numberOfGuests;
    private String status;

    public ReservationModel(Long id, Long restaurantId, String customerName, LocalDate reservationDate, LocalTime reservationTime, Integer numberOfGuests, String status) {
        this.id = id;
        this.restaurantId = restaurantId;
        this.customerName = customerName;
        this.reservationDate = reservationDate;
        this.reservationTime = reservationTime;
        this.numberOfGuests = numberOfGuests;
        this.status = status;
    }
}
