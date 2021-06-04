package com.metropolitan.courseholic.service.mapper;

import com.metropolitan.courseholic.model.*;
import com.metropolitan.courseholic.payload.*;
import com.metropolitan.courseholic.repository.RoleRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Service
public class EntityMapper {

    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    public EntityMapper(RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Category mapToCategoryEntity(CategoryDto categoryDto) {
        Category category = new Category();

        category.setName(categoryDto.getName());
        category.setImage(categoryDto.getImage());

        return category;
    }

    public Course mapToCourseEntity(CourseDto courseDto) {
        Course course = new Course();

        course.setName(courseDto.getName());
        course.setDescription(courseDto.getDescription());
        course.setLastUpdated(LocalDate.now());
        course.setPrice(courseDto.getPrice());
        course.setPicture(courseDto.getPicture());
        course.setVideo(courseDto.getVideo());
        course.setPublic(courseDto.isPublic());

        return course;
    }

    public Language mapToLanguageEntity(LanguageDto languageDto) {
        Language language = new Language();

        language.setName(languageDto.getName());

        return language;
    }

    public Lection mapToLectionEntity(LectionDto lectionDto) {
        Lection lection = new Lection();

        lection.setName(lectionDto.getName());
        lection.setDescription(lectionDto.getDescription());
        lection.setVideo(lectionDto.getVideo());

        return lection;
    }

    public Review mapToReviewEntity(ReviewDto reviewDto) {
        Review review = new Review();

        LocalDate now = LocalDate.now();

        review.setComment(reviewDto.getComment());
        review.setRating(reviewDto.getRating());
        review.setDateCreated(now);

        return review;
    }

    public Section mapToSectionEntity(SectionDto sectionDto) {
        Section section = new Section();

        section.setName(sectionDto.getName());

        return section;
    }

    public User mapToUserEntitySignUp(SignUpDto signUpDto) {
        User user = new User();
        user.setUsername(signUpDto.getUsername());
        user.setFirstName(signUpDto.getFirstName());
        user.setLastName(signUpDto.getLastName());
        user.setEmail(signUpDto.getEmail());
        user.setAvatar("http://localhost:8080/img/user.png");
        user.setDateCreated(LocalDate.now());
        user.setPassword(passwordEncoder.encode(signUpDto.getPassword()));
        user.setEnabled(true);

        Set<Role> roles = new HashSet<>();

        Role studentRole = roleRepository.findByName("STUDENT").get();

        roles.add(studentRole);

        if (signUpDto.getType().equals("AUTHOR")) {
            Role authorRole = roleRepository.findByName("AUTHOR").get();
            roles.add(authorRole);
        }

        user.setRoles(roles);

        return user;
    }

}