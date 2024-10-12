package com.challenge.restaurant.infra.repository;

import com.challenge.restaurant.domain.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByRestaurantId(Long restaurantId);
}
