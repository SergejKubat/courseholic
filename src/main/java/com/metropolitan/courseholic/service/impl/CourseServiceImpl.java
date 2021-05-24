package com.metropolitan.courseholic.service.impl;

import com.metropolitan.courseholic.model.Course;
import com.metropolitan.courseholic.payload.CourseDto;
import com.metropolitan.courseholic.repository.CourseRepository;
import com.metropolitan.courseholic.service.CourseService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CourseServiceImpl implements CourseService {

    private CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public CourseDto createCourse(CourseDto courseDto) {
        Course newCourse = new Course();

        LocalDate now = LocalDate.now();

        newCourse.setName(courseDto.getName());
        newCourse.setDescription(courseDto.getDescription());
        newCourse.setLastUpdated(now);
        newCourse.setPrice(courseDto.getPrice());
        newCourse.setPicture(courseDto.getPicture());
        newCourse.setVideo(courseDto.getVideo());
        newCourse.setPublic(courseDto.isPublic());

        courseRepository.save(newCourse);

        return null;
    }
}
