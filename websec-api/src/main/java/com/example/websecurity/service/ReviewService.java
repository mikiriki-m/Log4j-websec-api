package com.example.websecurity.service;

import com.example.websecurity.exception.WebSecMissingDataException;
import com.example.websecurity.persistence.Review;
import com.example.websecurity.persistence.ReviewRepository;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;

import static lombok.AccessLevel.PACKAGE;

@Service
@AllArgsConstructor(access = PACKAGE)
public class ReviewService {

    private static final Logger log = LogManager.getLogger(ReviewService.class);

    private final ReviewRepository reviewRepository;


    public Review getReviewById(Long id) {
        return reviewRepository.findById(id).orElseThrow(() -> new WebSecMissingDataException("Review with id " + id + " not found"));
    }

    public Review updateReview(Review review) {
        return reviewRepository.save(review);
    }

    public List<Review> getReviewsByUser(Long userId) {
        return reviewRepository.findByUserId(userId);
    }
}
