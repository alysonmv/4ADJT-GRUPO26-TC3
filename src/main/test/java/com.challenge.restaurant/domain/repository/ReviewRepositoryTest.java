package com.challenge.restaurant.repository;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;

@DataJdbcTest
public class ReviewRepositoryTest {

    @Autowired
    private ReviewRepository reviewRepository;

    @Test
    public void testFindByContent() {
        Review review = new Review("Loved it!", 4);
        reviewRepository.save(review);

        Review foundReview = reviewRepository.findByContent("Loved it!");
        assertThat(foundReview).isNotNull();
        assertThat(foundReview.getRating()).isEqualTo(4);
    }
}
