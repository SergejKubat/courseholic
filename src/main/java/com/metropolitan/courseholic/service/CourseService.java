package com.metropolitan.courseholic.service;

import com.metropolitan.courseholic.payload.CourseDto;
import com.metropolitan.courseholic.payload.CourseListDto;
import com.metropolitan.courseholic.payload.CourseResponse;

import java.util.List;

public interface CourseService {

    CourseDto createCourse(String username, long categoryId, int languageId, CourseDto courseDto);

    List<CourseResponse> findAllByUserUsername(String username);

    CourseListDto findAll(int pageNo, int pageSize, String sortBy, String sortDir);

    CourseResponse getCourseById(String username, long courseId);

    CourseDto updateCourse(String username, long courseId, CourseDto courseDto);

    void deleteCourse(String username, long courseId);

}
