package com.challenge.restaurant.application.controller.review;

import com.challenge.restaurant.application.controller.review.request.ReviewRequest;
import com.challenge.restaurant.application.response.GenericResponse;
import com.challenge.restaurant.application.response.PresenterResponse;
import com.challenge.restaurant.domain.entity.review.Review;
import com.challenge.restaurant.domain.generic.OutputInterface;
import com.challenge.restaurant.domain.input.ReviewInput;
import com.challenge.restaurant.domain.output.review.CreateReviewOutput;
import com.challenge.restaurant.domain.present.review.IdentifyReviewPresenter;
import com.challenge.restaurant.domain.useCase.review.CreateReviewUseCase;
import com.challenge.restaurant.infra.adapter.repository.CreateReviewRepository;
import com.challenge.restaurant.infra.repository.ReviewRepository;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/review/create")
public class ReviewController {

    private final ReviewRepository reviewRepository;

    @PostMapping
    @Operation(tags = {"review"})
    public ResponseEntity<Object> createReview(@RequestBody ReviewRequest reviewRequest) throws Exception {

        ReviewInput reviewInput = new ReviewInput(
                reviewRequest.restaurantId(),
                reviewRequest.userId(),
                reviewRequest.rating(),
                reviewRequest.comment()
        );

        CreateReviewUseCase useCase = new CreateReviewUseCase(new CreateReviewRepository(reviewRepository));
        useCase.create(reviewInput);

        OutputInterface outputInterface = useCase.getCreateReviewOutputInterface();

        if (outputInterface.getOutputStatus().getCode() != 200) {
            return new GenericResponse().response(outputInterface);
        }

        IdentifyReviewPresenter presenter = new IdentifyReviewPresenter((CreateReviewOutput) outputInterface);

        return new PresenterResponse().response(presenter);
    }
}
