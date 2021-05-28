package com.metropolitan.courseholic.controller;

import com.metropolitan.courseholic.payload.CourseDto;
import com.metropolitan.courseholic.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/")
public class CourseController {

    private CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PreAuthorize("hasRole('USER')")
    @PostMapping("/users/{username}/courses")
    public ResponseEntity<CourseDto> createCourse(@PathVariable(value = "username") String username, @Valid @RequestBody CourseDto courseDto) {
        return new ResponseEntity<>(courseService.createCourse(username, 1, 1, courseDto), HttpStatus.CREATED);
    }

    @GetMapping("/users/{username}/courses")
    public List<CourseDto> findCoursesByUserId(@PathVariable(value = "username") String username) {
        return courseService.findAllByUserUsername(username);
    }

    @GetMapping("/users/{username}/courses/{courseId}")
    public ResponseEntity<CourseDto> getCourseById(@PathVariable(value = "username") String username,
                                                   @PathVariable(value = "courseId") long courseId) {
        CourseDto courseDto = courseService.getCourseById(username, courseId);
        return new ResponseEntity<>(courseDto, HttpStatus.OK);
    }

    @PutMapping("/users/{username}/courses/{courseId}")
    public ResponseEntity<CourseDto> updateCourse(@PathVariable(value = "username") String username,
                                                  @PathVariable(value = "courseId") long courseId,
                                                  @Valid @RequestBody CourseDto courseDto) {
        CourseDto updatedCourse = courseService.updateCourse(username, courseId, courseDto);
        return new ResponseEntity<>(updatedCourse, HttpStatus.OK);
    }

    @DeleteMapping("/users/{username}/courses/{courseId}")
    public ResponseEntity<String> deleteCourse(@PathVariable(value = "username") String username,
                                               @PathVariable(value = "courseId") long courseId) {
        courseService.deleteCourse(username, courseId);
        return new ResponseEntity<>("Course deleted successfully", HttpStatus.OK);
    }
}