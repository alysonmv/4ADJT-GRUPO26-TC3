package com.challenge.restaurant.infra.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "restaurants")
public class RestaurantModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String cnpj;
    private String location;
    private String cuisineType;
    private Integer capacity;
    private String openingHours;

    public RestaurantModel(Long id, String name, String cnpj, String location, String cuisineType, Integer capacity, String openingHours) {
        this.id = id;
        this.name = name;
        this.cnpj = cnpj;
        this.location = location;
        this.cuisineType = cuisineType;
        this.capacity = capacity;
        this.openingHours = openingHours;
    }
}
