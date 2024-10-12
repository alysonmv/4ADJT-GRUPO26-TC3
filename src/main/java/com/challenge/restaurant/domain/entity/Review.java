package com.challenge.restaurant.domain.entity;

import com.challenge.restaurant.domain.entity.restaurant.Restaurant;
import jakarta.persistence.*;
import lombok.*;

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
    private Restaurant restaurant;

    @Column(nullable = false)
    private int note;

    private String comment;

    @Column(name = "data_avaliacao", nullable = false)
    private LocalDateTime reviewDate = LocalDateTime.now();
}
