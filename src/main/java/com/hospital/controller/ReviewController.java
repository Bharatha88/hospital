package com.hospital.controller;

import com.hospital.dto.Review;
import com.hospital.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void createReview(@RequestBody Review review){
        service.createReview(review);

    }
    //Get review from Database
    @GetMapping
    public List<Review> retrieveAllReviews(@RequestParam(required = false) String reviewNumber) {
        return service.retrieveAllReviews(reviewNumber);
    }

    //Delete review from DB
    @DeleteMapping("/{reviewId}")
    Map removeReview(@PathVariable Long reviewId){
        Boolean response = service.removeReview(reviewId);
        if(response){
            return Collections.singletonMap("status","Record removed");
        }
        return Collections.singletonMap("status","Appointment not found");
    }

}

