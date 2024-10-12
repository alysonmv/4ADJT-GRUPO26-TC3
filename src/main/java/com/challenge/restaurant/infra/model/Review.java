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
@Table(name = "avaliacoes")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_restaurante", nullable = false)
    private RestaurantModel restaurantModel;

    @Column(nullable = false)
    private int note;

    private String comment;

    @Column(name = "data_avaliacao", nullable = false)
    private LocalDateTime reviewDate = LocalDateTime.now();
}
