package com.challenge.restaurant.infra.repository;

import com.challenge.restaurant.infra.model.ReviewModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<ReviewModel, Long> {
}
