package com.metropolitan.courseholic.service;

import com.metropolitan.courseholic.payload.ReviewDto;

import java.util.List;

public interface ReviewService {

    ReviewDto createReview(long courseId, ReviewDto reviewDto);

    List<ReviewDto> findAllByUsername(String username);

    List<ReviewDto> findAllByCourseId(long courseId);

    ReviewDto updateReview(long courseId, long reviewId, ReviewDto reviewDto);

    void deleteReview(long courseId, long reviewId);

}
