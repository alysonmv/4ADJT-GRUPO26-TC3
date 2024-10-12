package com.challenge.restaurant.domain.present.review;

import com.challenge.restaurant.domain.generic.presenter.PresenterInterface;
import com.challenge.restaurant.domain.output.review.CreateReviewOutput;

import java.util.HashMap;
import java.util.Map;

public class IdentifyReviewPresenter implements PresenterInterface {
    private final CreateReviewOutput createReviewOutput;

    public IdentifyReviewPresenter(CreateReviewOutput createReviewOutput) {
        this.createReviewOutput = createReviewOutput;
    }

    @Override
    public Map<String, Object> toArray() {
        Map<String, Object> reviewMap = new HashMap<>();
        reviewMap.put("restaurantId", this.createReviewOutput.getReview().getRestaurantId());
        reviewMap.put("userId", this.createReviewOutput.getReview().getUserId());
        reviewMap.put("rating", this.createReviewOutput.getReview().getRating());
        reviewMap.put("comment", this.createReviewOutput.getReview().getComment());
        return reviewMap;
    }

    @Override
    public OutputInterface getOutput() {
        return this.createReviewOutput;
    }
}
