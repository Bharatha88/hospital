package com.hospital.service;

import com.hospital.dao.ReviewEntity;
import com.hospital.dto.Review;

import java.util.List;

public interface ReviewService {


    void createReview(Review review);

    List<Review> retrieveAllReviews();

    Iterable<ReviewEntity> retrieveReviewByReviewNumber(String reviewNumber);

    Boolean removeReview(Long reviewId);


}
