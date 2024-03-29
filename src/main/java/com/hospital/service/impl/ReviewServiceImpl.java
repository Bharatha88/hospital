package com.hospital.service.impl;


import com.hospital.dao.ReviewEntity;
import com.hospital.dto.Review;
import com.hospital.repository.ReviewRepository;
import com.hospital.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public  class ReviewServiceImpl implements ReviewService {

    @Autowired
    ReviewRepository reviewRepository;


    //save review
    public void createReview(Review review){
        ReviewEntity model = new ReviewEntity();
        model.setReviewNumber(review.getReviewNumber());
        model.setRating( review.getRating());
        model.setComment(review.getComment());
        reviewRepository.save(model);

    }

    //retrieve all reviews
    public List<Review> retrieveAllReviews(String reviewNumber){
        Iterable<ReviewEntity> reviews;
        if (reviewNumber != null){
            reviews = retrieveReviewByReviewNumber(reviewNumber);
        } else{
            reviews = reviewRepository.findAll();
        }

        Iterator<ReviewEntity> iterator = reviews.iterator();


        List<Review> reviewModelList = new ArrayList<>();

        while(iterator.hasNext()){
            ReviewEntity reviewDao = iterator.next();

            reviewModelList.add(
                    Review.builder()
                            .id(reviewDao.getId())
                            .reviewNumber(reviewDao.getReviewNumber())
                            .rating(reviewDao.getRating())
                            .comment(reviewDao.getComment())
                            .build()
            );
        }
        return reviewModelList;
    }

    //retrieve by reviewNumber
    public Iterable<ReviewEntity> retrieveReviewByReviewNumber(String reviewNumber){
        return reviewRepository.findAllByReviewNumber(reviewNumber);
    }

    //Delete review
    public Boolean removeReview(Long reviewId) {
        //using JPA
        Optional<ReviewEntity> reviewById = reviewRepository.findById(reviewId);
        if(reviewById.isPresent()){
            reviewRepository.deleteById(reviewId);
            return true;
        }
        return false;
    }

    //Update review
    public boolean updateReview(Long reviewId, Review updatedReview) {
        Optional<ReviewEntity> reviewOptional = reviewRepository.findById(reviewId);

        if (reviewOptional.isPresent()) {
            ReviewEntity existingReview = reviewOptional.get();

            // Update the existing review with the new information
            existingReview.setReviewNumber(updatedReview.getReviewNumber());
            existingReview.setRating(updatedReview.getRating());
            existingReview.setComment(updatedReview.getComment());

            // Save the updated review back to the repository
            reviewRepository.save(existingReview);

            return true;
        }

        // Patient with the given ID not found
        return false;
    }

}





