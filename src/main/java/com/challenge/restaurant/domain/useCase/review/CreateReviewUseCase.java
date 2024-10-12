package com.challenge.restaurant.domain.useCase.review;

import com.challenge.restaurant.domain.entity.review.Review;
import com.challenge.restaurant.domain.gateway.review.CreateReviewInterface;
import com.challenge.restaurant.domain.generic.OutputError;
import com.challenge.restaurant.domain.generic.OutputInterface;
import com.challenge.restaurant.domain.input.ReviewInput;
import com.challenge.restaurant.domain.output.review.CreateReviewOutput;
import lombok.Getter;

@Getter
public class CreateReviewUseCase {

    private final CreateReviewInterface createReviewInterface;
    private OutputInterface createReviewOutputInterface;

    public CreateReviewUseCase(CreateReviewInterface createReviewInterface) {
        this.createReviewInterface = createReviewInterface;
    }

    public void create(ReviewInput reviewInput) {
        try {
            Review review = new Review(
                    null,
                    reviewInput.getRestaurantId(),
                    reviewInput.getUserId(),
                    reviewInput.getRating(),
                    reviewInput.getComment()
            );

            review = review.createReview();
            Review savedReview = this.createReviewInterface.createReview(review);
            this.createReviewOutputInterface = new CreateReviewOutput(savedReview);

        } catch (Exception e) {
            this.createReviewOutputInterface = new OutputError(e.getMessage());
        }
    }
}
