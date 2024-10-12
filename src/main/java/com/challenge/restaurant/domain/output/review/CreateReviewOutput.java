package com.challenge.restaurant.domain.output.review;

import com.challenge.restaurant.domain.entity.review.Review;
import com.challenge.restaurant.domain.generic.OutputInterface;
import com.challenge.restaurant.domain.generic.output.OutputStatus;
import lombok.Data;

@Data
public class CreateReviewOutput implements OutputInterface {

    private final Review review;

    @Override
    public Object getBody() {
        return this.review;
    }

    @Override
    public OutputStatus getOutputStatus() {
        return new OutputStatus(200, "OK", "Review created successfully.");
    }
}
