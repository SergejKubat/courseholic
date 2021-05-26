package com.metropolitan.courseholic.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(unique = true)
    private String username;
    @Column(name = "first_name")
    @NotBlank(message = "First name is mandatory")
    private String firstName;
    @Column(name = "last_name")
    @NotBlank(message = "Last name is mandatory")
    private String lastName;
    @Column(unique = true)
    @NotBlank(message = "Email is mandatory")
    @Email
    private String email;
    private String avatar;
    @Column(name = "date_created")
    private LocalDate dateCreated;
    @NotBlank(message = "Password is mandatory")
    @Size(min = 8, max = 64, message = "Password length must be between 8 and 64 characters")
    private String password;
    private Boolean enabled;
    @ElementCollection
    @CollectionTable(name = "authorities",
            joinColumns = @JoinColumn(name = "username", referencedColumnName = "username"),
            uniqueConstraints = @UniqueConstraint(columnNames = {"username", "authority"}))
    @Column(name = "authority")
    private Set<String> authorities = new HashSet<>();
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Course> courses;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Review> reviews;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<PurchaseRecord> purchaseRecords;

    public User() {
    }

    public User(String username, String firstName, String lastName, String email, String avatar, LocalDate dateCreated, String password, Boolean enabled, String... authorities) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.avatar = avatar;
        this.dateCreated = dateCreated;
        this.password = password;
        this.enabled = enabled;
        this.authorities = new HashSet<>(Arrays.asList(authorities));
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Set<String> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(String... authorities) {
        this.authorities = new HashSet<>(Arrays.asList(authorities));
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
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
}