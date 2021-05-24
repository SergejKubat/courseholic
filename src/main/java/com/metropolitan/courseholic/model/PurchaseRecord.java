package com.metropolitan.courseholic.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "purchase_record")
public class PurchaseRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "date_created")
    private LocalDate dateCreated;
    @ManyToOne
    @JoinColumn(name = "username", nullable = false)
    private User user;
    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    public PurchaseRecord() {
    }

    public PurchaseRecord(LocalDate dateCreated, User user, Course course) {
        this.dateCreated = dateCreated;
        this.user = user;
        this.course = course;
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
