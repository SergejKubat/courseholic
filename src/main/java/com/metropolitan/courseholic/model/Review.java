package com.metropolitan.courseholic.model;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
@Table(name = "review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @NotBlank(message = "Review comment is mandatory")
    private String comment;
    @NotBlank(message = "Review rate is mandatory")
    @Min(value = 1, message = "Review rate should not be less than 1")
    @Max(value = 5, message = "Review rate should not be greater than 5")
    private Integer rating;
    @Column(name = "date_created")
    private LocalDate dateCreated;
    @ManyToOne
    @JoinColumn(name = "username", nullable = false)
    private User user;
    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    public Review() {
    }

    public Review(String comment, Integer rating, LocalDate dateCreated, User user, Course course) {
        this.comment = comment;
        this.rating = rating;
        this.dateCreated = dateCreated;
        this.user = user;
        this.course = course;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
