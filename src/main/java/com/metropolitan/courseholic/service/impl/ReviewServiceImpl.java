package com.metropolitan.courseholic.service.impl;

import com.metropolitan.courseholic.exception.ResourceNotFoundException;
import com.metropolitan.courseholic.model.Course;
import com.metropolitan.courseholic.model.Review;
import com.metropolitan.courseholic.model.User;
import com.metropolitan.courseholic.payload.ReviewDto;
import com.metropolitan.courseholic.repository.CourseRepository;
import com.metropolitan.courseholic.repository.ReviewRepository;
import com.metropolitan.courseholic.repository.UserRepository;
import com.metropolitan.courseholic.service.ReviewService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    private ReviewRepository reviewRepository;
    private UserRepository userRepository;
    private CourseRepository courseRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository, UserRepository userRepository, CourseRepository courseRepository) {
        this.reviewRepository = reviewRepository;
        this.userRepository = userRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public ReviewDto createReview(String username, long courseId, ReviewDto reviewDto) {
        Review review = mapToEntity(reviewDto);

        User user = userRepository.findById(username).orElseThrow(() -> new ResourceNotFoundException("User", "username", username));
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new ResourceNotFoundException("Course", "id", String.valueOf(courseId)));

        review.setUser(user);
        review.setCourse(course);

        Review newReview = reviewRepository.save(review);

        ReviewDto reviewResponse = mapToDto(newReview);

        return reviewResponse;
    }

    @Override
    public List<ReviewDto> findAllByUsername(String username) {
        return null;
    }

    @Override
    public List<ReviewDto> findAllByCourseId(long courseId) {
        return null;
    }

    @Override
    public ReviewDto updateReview(String username, long courseId, ReviewDto reviewDto) {
        return null;
    }

    @Override
    public void deleteReview(String username, long courseId, int reviewId) {

    }

    private ReviewDto mapToDto(Review review) {
        ReviewDto reviewDto = new ReviewDto();

        reviewDto.setId(review.getId());
        reviewDto.setComment(review.getComment());
        reviewDto.setRating(review.getRating());

        return reviewDto;
    }

    private Review mapToEntity(ReviewDto reviewDto) {
        Review review = new Review();

        LocalDate now = LocalDate.now();

        review.setComment(reviewDto.getComment());
        review.setRating(reviewDto.getRating());
        review.setDateCreated(now);

        return review;
    }

}
