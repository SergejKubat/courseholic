package com.metropolitan.courseholic.service.impl;

import com.metropolitan.courseholic.model.Course;
import com.metropolitan.courseholic.payload.SearchDto;
import com.metropolitan.courseholic.repository.CourseRepository;
import com.metropolitan.courseholic.service.SearchService;
import com.metropolitan.courseholic.service.mapper.DTOMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SearchServiceImpl implements SearchService {

    private CourseRepository courseRepository;
    private DTOMapper dtoMapper;

    public SearchServiceImpl(CourseRepository courseRepository, DTOMapper dtoMapper) {
        this.courseRepository = courseRepository;
        this.dtoMapper = dtoMapper;
    }

    @Override
    public List<SearchDto> getAllResults(String query) {
        List<Course> resultCourses = courseRepository.findByNameStartingWithIgnoreCase(query);

        return resultCourses.stream().map(resultCourse -> dtoMapper.mapToSearchDto(resultCourse)).collect(Collectors.toList());
    }

}