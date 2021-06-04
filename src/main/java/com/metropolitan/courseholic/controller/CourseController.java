package com.metropolitan.courseholic.controller;

import com.metropolitan.courseholic.payload.CourseDto;
import com.metropolitan.courseholic.payload.CourseListDto;
import com.metropolitan.courseholic.payload.CourseResponse;
import com.metropolitan.courseholic.service.CourseService;
import com.metropolitan.courseholic.utils.AppConstants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/")
public class CourseController {

    private CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PreAuthorize("hasAuthority('AUTHOR')")
    @PostMapping("/users/{username}/courses")
    public ResponseEntity<CourseDto> createCourse(@PathVariable(value = "username") String username, @Valid @RequestBody CourseDto courseDto) {
        return new ResponseEntity<>(courseService.createCourse(username, 1, 1, courseDto), HttpStatus.CREATED);
    }

    @GetMapping("/users/{username}/courses")
    public List<CourseResponse> findCoursesByUserId(@PathVariable(value = "username") String username) {
        return courseService.findAllByUserUsername(username);
    }

    @GetMapping("/courses")
    public CourseListDto findAll(
            @RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = "name", required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir,
            @RequestParam(value = "categoryId", defaultValue = "0", required = false) long categoryId) {
        return courseService.findAll(pageNo, pageSize, sortBy, sortDir, categoryId);
    }

    @GetMapping("/users/{username}/courses/{courseId}")
    public ResponseEntity<CourseResponse> getCourseById(@PathVariable(value = "username") String username,
                                                        @PathVariable(value = "courseId") long courseId) {
        CourseResponse courseResponse = courseService.getCourseById(username, courseId);
        return new ResponseEntity<>(courseResponse, HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('AUTHOR')")
    @PutMapping("/users/{username}/courses/{courseId}")
    public ResponseEntity<CourseDto> updateCourse(@PathVariable(value = "username") String username,
                                                  @PathVariable(value = "courseId") long courseId,
                                                  @Valid @RequestBody CourseDto courseDto) {
        CourseDto updatedCourse = courseService.updateCourse(username, courseId, courseDto);
        return new ResponseEntity<>(updatedCourse, HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('AUTHOR')")
    @DeleteMapping("/users/{username}/courses/{courseId}")
    public ResponseEntity<String> deleteCourse(@PathVariable(value = "username") String username,
                                               @PathVariable(value = "courseId") long courseId) {
        courseService.deleteCourse(username, courseId);
        return new ResponseEntity<>("Course deleted successfully", HttpStatus.OK);
    }
}
