package com.hospital.controller;

import com.hospital.dto.Prescription;
import com.hospital.dto.Review;
import com.hospital.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/review")
public class ReviewController {

    @Autowired
    ReviewService service;

    //Create review from UI
    @PostMapping
    public void createReview(@RequestBody Review review) {
        service.createReview(review);

    }

    //Get review from Database
    @GetMapping
    public List<Review> retrieveAllReviews(@RequestParam(required = false) String reviewNumber) {
        return service.retrieveAllReviews(reviewNumber);
    }

    //Delete review from DB
    @DeleteMapping("/{reviewId}")
    Map removeReview(@PathVariable Long reviewId) {
        Boolean response = service.removeReview(reviewId);
        if (response) {
            return Collections.singletonMap("status", "Record removed");
        }
        return Collections.singletonMap("status", "Appointment not found");
    }

    //Update review
    @PutMapping("/{reviewId}")
    public ResponseEntity<Map<String, String>> updateReview(
            @PathVariable Long reviewId,
            @RequestBody Review updatedReview) {

        boolean success = service.updateReview(reviewId, updatedReview);

        if (success) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(Collections.singletonMap("status", "Record updated successfully"));
        } else return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Collections.singletonMap("status", "Review not found"));
    }
}


