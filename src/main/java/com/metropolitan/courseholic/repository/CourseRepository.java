package com.metropolitan.courseholic.repository;

import com.metropolitan.courseholic.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> findAllByUserUsername(String username);

    List<Course> findAllByCategoryId(long categoryId);

    List<Course> findByNameStartingWithIgnoreCase(String query);

}
