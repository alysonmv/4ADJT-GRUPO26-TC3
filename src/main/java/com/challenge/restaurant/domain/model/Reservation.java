package com.challenge.restaurant.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;

    @Column(nullable = false)
    private String customerName;

    @Column(nullable = false)
    private LocalDateTime reservationDateTime; // Combine data e hora

    @Column(nullable = false)
    private int numberOfGuests;
}
