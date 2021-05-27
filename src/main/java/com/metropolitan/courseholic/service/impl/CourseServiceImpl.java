package com.metropolitan.courseholic.service.impl;

import com.metropolitan.courseholic.exception.CourseholicAPIException;
import com.metropolitan.courseholic.exception.ResourceNotFoundException;
import com.metropolitan.courseholic.model.Category;
import com.metropolitan.courseholic.model.Course;
import com.metropolitan.courseholic.model.Language;
import com.metropolitan.courseholic.model.User;
import com.metropolitan.courseholic.payload.CourseDto;
import com.metropolitan.courseholic.repository.CategoryRepository;
import com.metropolitan.courseholic.repository.CourseRepository;
import com.metropolitan.courseholic.repository.LanguageRepository;
import com.metropolitan.courseholic.repository.UserRepository;
import com.metropolitan.courseholic.service.CourseService;
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

    public CourseServiceImpl(CourseRepository courseRepository, UserRepository userRepository, CategoryRepository categoryRepository, LanguageRepository languageRepository) {
        this.courseRepository = courseRepository;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
        this.languageRepository = languageRepository;
    }

    @Override
    public CourseDto createCourse(String username, long categoryId, int languageId, CourseDto courseDto) {
        Course course = mapToEntity(courseDto);

        User user = userRepository.findById(username).orElseThrow(() -> new ResourceNotFoundException("User", "username", username));
        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("category", "id", String.valueOf(categoryId)));
        Language language = languageRepository.findById(languageId).orElseThrow(() -> new ResourceNotFoundException("language", "id", String.valueOf(languageId)));

        course.setUser(user);
        course.setCategory(category);
        course.setLanguage(language);

        Course newCourse = courseRepository.save(course);

        CourseDto courseResponse = mapToDTO(newCourse);

        return courseResponse;
    }

    @Override
    public List<CourseDto> findAllByUserUsername(String username) {
        List<Course> courses = courseRepository.findAllByUserUsername(username);

        return courses.stream().map(course -> mapToDTO(course)).collect(Collectors.toList());
    }

    @Override
    public CourseDto getCourseById(String username, long courseId) {

        User user = userRepository.findById(username).orElseThrow(() -> new ResourceNotFoundException("User", "username", username));
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new ResourceNotFoundException("Course", "id", String.valueOf(courseId)));

        if (!course.getUser().getUsername().equals(user.getUsername())) {
            throw new CourseholicAPIException(HttpStatus.BAD_REQUEST, "Course does not belong to user.");
        }

        return mapToDTO(course);
    }

    @Override
    public CourseDto updateCourse(String username, long courseId, CourseDto courseDto) {

        User user = userRepository.findById(username).orElseThrow(() -> new ResourceNotFoundException("User", "username", username));
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new ResourceNotFoundException("Course", "id", String.valueOf(courseId)));

        if (!course.getUser().getUsername().equals(user.getUsername())) {
            throw new CourseholicAPIException(HttpStatus.BAD_REQUEST, "Course does not belong to user.");
        }

        course.setName(courseDto.getName());
        course.setDescription(courseDto.getDescription());
        course.setLastUpdated(getDate());
        course.setPrice(courseDto.getPrice());
        course.setPicture(course.getPicture());
        course.setVideo(courseDto.getVideo());
        course.setPublic(courseDto.isPublic());

        Course updatedCourse = courseRepository.save(course);

        CourseDto courseResponse = mapToDTO(updatedCourse);

        return courseResponse;
    }

    @Override
    public void deleteCourse(String username, long courseId) {
        User user = userRepository.findById(username).orElseThrow(() -> new ResourceNotFoundException("User", "username", username));
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new ResourceNotFoundException("Course", "id", String.valueOf(courseId)));

        if (!course.getUser().getUsername().equals(user.getUsername())) {
            throw new CourseholicAPIException(HttpStatus.BAD_REQUEST, "Course does not belong to user.");
        }

        courseRepository.delete(course);
    }

    private CourseDto mapToDTO(Course course) {
        CourseDto courseDto = new CourseDto();

        courseDto.setId(course.getId());
        courseDto.setName(course.getName());
        courseDto.setDescription(course.getDescription());
        courseDto.setLastUpdated(course.getLastUpdated());
        courseDto.setPrice(course.getPrice());
        courseDto.setPicture(course.getPicture());
        courseDto.setVideo(course.getVideo());
        course.setPublic(course.isPublic());

        return courseDto;
    }

    private Course mapToEntity(CourseDto courseDto) {
        Course course = new Course();

        course.setName(courseDto.getName());
        course.setDescription(courseDto.getDescription());
        course.setLastUpdated(getDate());
        course.setPrice(courseDto.getPrice());
        course.setPicture(courseDto.getPicture());
        course.setVideo(courseDto.getVideo());
        course.setPublic(courseDto.isPublic());

        return course;
    }

    private LocalDate getDate() {
        LocalDate now = LocalDate.now();
        return now;
    }
}
