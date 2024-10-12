package com.challenge.restaurant.infra.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private RestaurantModel restaurantModel;

    @Column(nullable = false)
    private String customerName;

    @Column(nullable = false)
    private LocalDateTime reservationDateTime; // Combine data e hora

    @Column(nullable = false)
    private int numberOfGuests;
}
