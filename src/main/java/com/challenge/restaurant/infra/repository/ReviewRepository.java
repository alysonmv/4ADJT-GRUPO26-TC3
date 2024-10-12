package com.challenge.restaurant.infra.repository;
import com.challenge.restaurant.domain.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByRestaurantId(Long restaurantId);
}
