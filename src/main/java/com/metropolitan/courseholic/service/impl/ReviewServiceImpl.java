package com.metropolitan.courseholic.service.impl;

import com.metropolitan.courseholic.exception.CourseholicAPIException;
import com.metropolitan.courseholic.exception.ResourceNotFoundException;
import com.metropolitan.courseholic.model.Course;
import com.metropolitan.courseholic.model.Review;
import com.metropolitan.courseholic.model.User;
import com.metropolitan.courseholic.payload.ReviewDto;
import com.metropolitan.courseholic.repository.CourseRepository;
import com.metropolitan.courseholic.repository.ReviewRepository;
import com.metropolitan.courseholic.repository.UserRepository;
import com.metropolitan.courseholic.security.SecurityUtils;
import com.metropolitan.courseholic.service.ReviewService;
import com.metropolitan.courseholic.service.mapper.DTOMapper;
import com.metropolitan.courseholic.service.mapper.EntityMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewServiceImpl implements ReviewService {

    private ReviewRepository reviewRepository;
    private UserRepository userRepository;
    private CourseRepository courseRepository;

    private EntityMapper entityMapper;
    private DTOMapper dtoMapper;

    public ReviewServiceImpl(ReviewRepository reviewRepository, UserRepository userRepository, CourseRepository courseRepository, EntityMapper entityMapper, DTOMapper dtoMapper) {
        this.reviewRepository = reviewRepository;
        this.userRepository = userRepository;
        this.courseRepository = courseRepository;
        this.entityMapper = entityMapper;
        this.dtoMapper = dtoMapper;
    }

    @Override
    public ReviewDto createReview(long courseId, ReviewDto reviewDto) {

        if (!checkIfCourseIsPurchased(courseId)) {
            throw new CourseholicAPIException(HttpStatus.BAD_REQUEST, "You must purchase this course before sending review.");
        }

        if (checkIfCourseIsReviewed(courseId)) {
            throw new CourseholicAPIException(HttpStatus.BAD_REQUEST, "You have already reviewed this course.");
        }

        Review review = entityMapper.mapToReviewEntity(reviewDto);

        User user = userRepository.findById(SecurityUtils.getCurrentUserUsername()).get();
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new ResourceNotFoundException("Course", "id", String.valueOf(courseId)));

        review.setUser(user);
        review.setCourse(course);

        Review newReview = reviewRepository.save(review);

        ReviewDto reviewResponse = dtoMapper.mapToReviewDto(newReview);

        return reviewResponse;
    }

    @Override
    public List<ReviewDto> findAllByUsername(String username) {
        List<Review> reviews = reviewRepository.findByUserUsername(username);

        return reviews.stream().map(review -> dtoMapper.mapToReviewDto(review)).collect(Collectors.toList());
    }

    @Override
    public List<ReviewDto> findAllByCourseId(long courseId) {
        List<Review> reviews = reviewRepository.findByCourseId(courseId);

        return reviews.stream().map(review -> dtoMapper.mapToReviewDto(review)).collect(Collectors.toList());
    }

    @Override
    public ReviewDto updateReview(long courseId, long reviewId, ReviewDto reviewDto) {
        checkReview(courseId, reviewId);

        if (!checkIfCourseIsPurchased(courseId)) {
            throw new CourseholicAPIException(HttpStatus.BAD_REQUEST, "You must purchase this course before updating review.");
        }

        if (!checkIfCourseIsReviewed(courseId)) {
            throw new CourseholicAPIException(HttpStatus.BAD_REQUEST, "You have not reviewed this course.");
        }

        Review review = reviewRepository.findById(reviewId).get();

        review.setComment(reviewDto.getComment());
        review.setRating(reviewDto.getRating());

        Review updatedReview = reviewRepository.save(review);

        ReviewDto reviewResponse = dtoMapper.mapToReviewDto(updatedReview);

        return reviewResponse;
    }

    @Override
    public void deleteReview(long courseId, long reviewId) {
        checkReview(courseId, reviewId);

        if (!checkIfCourseIsPurchased(courseId)) {
            throw new CourseholicAPIException(HttpStatus.BAD_REQUEST, "You must purchase this course before deleting review.");
        }

        if (!checkIfCourseIsReviewed(courseId)) {
            throw new CourseholicAPIException(HttpStatus.BAD_REQUEST, "You have not reviewed this course.");
        }

        reviewRepository.delete(reviewRepository.findById(reviewId).get());
    }

    private void checkReview(long courseId, long reviewId) {
        User user = userRepository.findById(SecurityUtils.getCurrentUserUsername()).get();
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new ResourceNotFoundException("Course", "id", String.valueOf(courseId)));
        Review review = reviewRepository.findById(reviewId).orElseThrow(() -> new ResourceNotFoundException("Review", "id", String.valueOf(reviewId)));

        if (review.getCourse().getId() != course.getId()) {
            throw new CourseholicAPIException(HttpStatus.BAD_REQUEST, "Review does not belong to course.");
        }

        if (!review.getUser().getUsername().equals(user.getUsername())) {
            throw new CourseholicAPIException(HttpStatus.BAD_REQUEST, "Review does not belong to user.");
        }

    }

    private boolean checkIfCourseIsPurchased(long courseId) {
        User user = userRepository.findById(SecurityUtils.getCurrentUserUsername()).get();
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new ResourceNotFoundException("Course", "id", String.valueOf(courseId)));

        return user.getPurchaseRecords().stream().anyMatch(purchaseRecord -> purchaseRecord.getCourse().getId() == course.getId());
    }

    private boolean checkIfCourseIsReviewed(long courseId) {
        User user = userRepository.findById(SecurityUtils.getCurrentUserUsername()).get();
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new ResourceNotFoundException("Course", "id", String.valueOf(courseId)));

        return user.getReviews().stream().anyMatch(review -> review.getCourse().getId() == course.getId());
    }

}