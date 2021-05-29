package com.metropolitan.courseholic.controller;

import com.metropolitan.courseholic.payload.ReviewDto;
import com.metropolitan.courseholic.service.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping
    public ResponseEntity<ReviewDto> createReview(@RequestParam(value = "username") String username,
                                                  @RequestParam(value = "courseId") long courseId,
                                                  @RequestBody ReviewDto reviewDto) {
        return new ResponseEntity<>(reviewService.createReview(username, courseId, reviewDto), HttpStatus.CREATED);
    }

}
