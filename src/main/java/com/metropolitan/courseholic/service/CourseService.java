package com.metropolitan.courseholic.service;

import com.metropolitan.courseholic.payload.CourseDto;
import com.metropolitan.courseholic.payload.CourseResponse;

import java.util.List;

public interface CourseService {

    CourseDto createCourse(String username, long categoryId, int languageId, CourseDto courseDto);

    List<CourseDto> findAllByUserUsername(String username);

    CourseResponse getCourseById(String username, long courseId);

    CourseDto updateCourse(String username, long courseId, CourseDto courseDto);

    void deleteCourse(String username, long courseId);

}
