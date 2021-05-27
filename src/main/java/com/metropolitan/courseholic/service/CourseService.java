package com.metropolitan.courseholic.service;

import com.metropolitan.courseholic.payload.CourseDto;

import java.util.List;

public interface CourseService {

    CourseDto createCourse(String username, long categoryId, int languageId, CourseDto courseDto);

    List<CourseDto> findAllByUserUsername(String username);

    CourseDto getCourseById(String username, long courseId);

    CourseDto updateCourse(String username, long courseId, CourseDto courseDto);

    void deleteCourse(String username, long courseId);

}
