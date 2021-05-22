package com.metropolitan.courseholic.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(unique = true)
    @NotBlank(message = "Course name is mandatory")
    @Size(min = 5, max = 150, message = "Course name length must be between 5 and 150 characters")
    private String name;
    @NotBlank(message = "Course description is mandatory")
    @Min(value = 50, message = "Course description length must be greater than 50 characters")
    private String description;
    @Column(name = "last_updated")
    private LocalDate lastUpdated;
    @NotBlank(message = "Course price is mandatory")
    private Double price;
    @NotBlank(message = "Course picture is mandatory")
    private String picture;
    @NotBlank(message = "Course video is mandatory")
    private String video;
    private Boolean isPublic;
    @ManyToOne
    @JoinColumn(name = "username", nullable = false)
    private User user;
    @OneToMany(mappedBy = "course")
    private Set<Review> reviews;
    @OneToMany(mappedBy = "course")
    private Set<PurchaseRecord> purchaseRecords;
    @OneToMany(mappedBy = "course")
    private Set<Section> sections;
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;
    @ManyToOne
    @JoinColumn(name = "language_id", nullable = false)
    private Language language;

    public Course() {
    }

    public Course(String name, String description, LocalDate lastUpdated, Double price, String picture, String video, Boolean isPublic, User user, Category category, Language language) {
        this.name = name;
        this.description = description;
        this.lastUpdated = lastUpdated;
        this.price = price;
        this.picture = picture;
        this.video = video;
        this.isPublic = isPublic;
        this.user = user;
        this.category = category;
        this.language = language;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDate lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public Boolean getPublic() {
        return isPublic;
    }

    public void setPublic(Boolean aPublic) {
        isPublic = aPublic;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Review> getReviews() {
        return reviews;
    }

    public void setReviews(Set<Review> reviews) {
        this.reviews = reviews;
    }

    public Set<PurchaseRecord> getPurchaseRecords() {
        return purchaseRecords;
    }

    public void setPurchaseRecords(Set<PurchaseRecord> purchaseRecords) {
        this.purchaseRecords = purchaseRecords;
    }

    public Set<Section> getSections() {
        return sections;
    }

    public void setSections(Set<Section> sections) {
        this.sections = sections;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
