package com.metropolitan.courseholic.service.impl;

import com.metropolitan.courseholic.exception.CourseholicAPIException;
import com.metropolitan.courseholic.exception.ResourceNotFoundException;
import com.metropolitan.courseholic.model.*;
import com.metropolitan.courseholic.payload.*;
import com.metropolitan.courseholic.repository.CategoryRepository;
import com.metropolitan.courseholic.repository.CourseRepository;
import com.metropolitan.courseholic.repository.LanguageRepository;
import com.metropolitan.courseholic.repository.UserRepository;
import com.metropolitan.courseholic.service.CourseService;
import com.metropolitan.courseholic.service.mapper.DTOMapper;
import com.metropolitan.courseholic.service.mapper.EntityMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {

    private CourseRepository courseRepository;
    private UserRepository userRepository;
    private CategoryRepository categoryRepository;
    private LanguageRepository languageRepository;

    private EntityMapper entityMapper;
    private DTOMapper dtoMapper;

    public CourseServiceImpl(CourseRepository courseRepository, UserRepository userRepository, CategoryRepository categoryRepository, LanguageRepository languageRepository, EntityMapper entityMapper, DTOMapper dtoMapper) {
        this.courseRepository = courseRepository;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
        this.languageRepository = languageRepository;
        this.entityMapper = entityMapper;
        this.dtoMapper = dtoMapper;
    }

    @Override
    public CourseDto createCourse(String username, long categoryId, int languageId, CourseDto courseDto) {
        Course course = entityMapper.mapToCourseEntity(courseDto);

        User user = userRepository.findById(username).orElseThrow(() -> new ResourceNotFoundException("User", "username", username));
        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("category", "id", String.valueOf(categoryId)));
        Language language = languageRepository.findById(languageId).orElseThrow(() -> new ResourceNotFoundException("language", "id", String.valueOf(languageId)));

        course.setUser(user);
        course.setCategory(category);
        course.setLanguage(language);

        Course newCourse = courseRepository.save(course);

        CourseDto courseResponse = dtoMapper.mapToCourseDTO(newCourse);

        return courseResponse;
    }

    @Override
    public List<CourseResponse> findAllByUserUsername(String username) {
        List<Course> courses = courseRepository.findAllByUserUsername(username);

        return courses.stream().map(course -> dtoMapper.mapToCourseResponse(course)).collect(Collectors.toList());
    }

    @Override
    public CourseListDto findAll(int pageNo, int pageSize, String sortBy, String sortDir, long categoryId) {

        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

        Page<Course> courses = courseRepository.findAll(pageable);

        List<Course> listOfCourses = courses.getContent();

        if (categoryId != 0) {
            listOfCourses.stream().filter(course -> course.getCategory().getId() == categoryId);
        }

        List<CourseResponse> content = listOfCourses.stream().map(course -> dtoMapper.mapToCourseResponse(course)).collect(Collectors.toList());

        CourseListDto courseListDto = new CourseListDto();
        courseListDto.setCourses(content);
        courseListDto.setPageNo(courses.getNumber());
        courseListDto.setPageSize(courses.getSize());
        courseListDto.setTotalElements(courses.getTotalElements());
        courseListDto.setTotalPages(courses.getTotalPages());
        courseListDto.setLast(courses.isLast());

        return courseListDto;
    }

    @Override
    public CourseResponse getCourseById(String username, long courseId) {
        checkCourse(username, courseId);

        return dtoMapper.mapToCourseResponse(courseRepository.findById(courseId).get());
    }

    @Override
    public CourseDto updateCourse(String username, long courseId, CourseDto courseDto) {
        checkCourse(username, courseId);

        Course course = courseRepository.findById(courseId).get();

        course.setName(courseDto.getName());
        course.setDescription(courseDto.getDescription());
        course.setLastUpdated(LocalDate.now());
        course.setPrice(courseDto.getPrice());
        course.setPicture(course.getPicture());
        course.setVideo(courseDto.getVideo());
        course.setPublic(courseDto.isPublic());

        Course updatedCourse = courseRepository.save(course);

        CourseDto courseResponse = dtoMapper.mapToCourseDTO(updatedCourse);

        return courseResponse;
    }

    @Override
    public void deleteCourse(String username, long courseId) {
        checkCourse(username, courseId);

        courseRepository.delete(courseRepository.findById(courseId).get());
    }

    public void checkCourse(String username, long courseId) {
        User user = userRepository.findById(username).orElseThrow(() -> new ResourceNotFoundException("User", "username", username));
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new ResourceNotFoundException("Course", "id", String.valueOf(courseId)));

        if (!course.getUser().getUsername().equals(user.getUsername())) {
            throw new CourseholicAPIException(HttpStatus.BAD_REQUEST, "Course does not belong to user.");
        }
    }

}