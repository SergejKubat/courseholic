package com.metropolitan.courseholic.controller;

import com.metropolitan.courseholic.payload.ReviewDto;
import com.metropolitan.courseholic.service.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class ReviewController {

    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @CrossOrigin
    @PostMapping("/courses/{courseId}/reviews")
    public ResponseEntity<ReviewDto> createReview(@PathVariable(value = "courseId") long courseId,
                                                  @RequestBody ReviewDto reviewDto) {
        return new ResponseEntity<>(reviewService.createReview(courseId, reviewDto), HttpStatus.CREATED);
    }

    @CrossOrigin
    @GetMapping("/users/{username}/reviews")
    public List<ReviewDto> findAllByUsername(@PathVariable(value = "username") String username) {
        return reviewService.findAllByUsername(username);
    }

    @CrossOrigin
    @GetMapping("/courses/{courseId}/reviews")
    public List<ReviewDto> findAllByCourseId(@PathVariable(value = "courseId") long courseId) {
        return reviewService.findAllByCourseId(courseId);
    }

    @CrossOrigin
    @PutMapping("/courses/{courseId}/reviews/{reviewId}")
    public ResponseEntity<ReviewDto> updateReview(@PathVariable(value = "courseId") long courseId,
                                                  @PathVariable(value = "reviewId") long reviewId,
                                                  @RequestBody ReviewDto reviewDto) {
        ReviewDto updatedReview = reviewService.updateReview(courseId, reviewId, reviewDto);
        return new ResponseEntity<>(updatedReview, HttpStatus.OK);
    }

    @CrossOrigin
    @DeleteMapping("/courses/{courseId}/reviews/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable(value = "courseId") long courseId,
                                                  @PathVariable(value = "reviewId") long reviewId) {
        reviewService.deleteReview(courseId, reviewId);
        return new ResponseEntity<>("Review deleted successfully", HttpStatus.OK);
    }

}