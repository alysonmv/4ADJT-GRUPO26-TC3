package com.challenge.restaurant.infra.adapter.repository;

import com.challenge.restaurant.domain.entity.review.Review;
import com.challenge.restaurant.domain.gateway.review.CreateReviewInterface;
import com.challenge.restaurant.infra.model.ReviewModel;
import com.challenge.restaurant.infra.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateReviewRepository implements CreateReviewInterface {

    private final ReviewRepository reviewRepository;

    @Override
    public Review createReview(Review review) {
        ReviewModel reviewModel = new ReviewModel(null, review.getRestaurantId(), review.getUserId(), review.getRating(), review.getComment());
        ReviewModel savedReviewModel = reviewRepository.save(reviewModel);
        return new Review(savedReviewModel.getId(), savedReviewModel.getRestaurantId(), savedReviewModel.getUserId(), savedReviewModel.getRating(), savedReviewModel.getComment());
    }
}
