package com.metropolitan.courseholic.service;

import com.metropolitan.courseholic.payload.ReviewDto;

import java.util.List;

public interface ReviewService {

    ReviewDto createReview(String username, long courseId, ReviewDto reviewDto);

    List<ReviewDto> findAllByUsername(String username);

    List<ReviewDto> findAllByCourseId(long courseId);

    ReviewDto updateReview(String username, long courseId, ReviewDto reviewDto);

    void deleteReview(String username, long courseId, int reviewId);

}
