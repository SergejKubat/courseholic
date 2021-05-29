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
    public CourseResponse getCourseById(String username, long courseId) {

        User user = userRepository.findById(username).orElseThrow(() -> new ResourceNotFoundException("User", "username", username));
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new ResourceNotFoundException("Course", "id", String.valueOf(courseId)));

        if (!course.getUser().getUsername().equals(user.getUsername())) {
            throw new CourseholicAPIException(HttpStatus.BAD_REQUEST, "Course does not belong to user.");
        }

        return mapToCourseResponse(course);
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

    private CourseResponse mapToCourseResponse(Course course) {
        CourseResponse courseResponse = new CourseResponse();

        courseResponse.setCourse(mapToDTO(course));
        courseResponse.setUser(mapToUserDTO(course.getUser()));
        courseResponse.setCategory(mapToCategoryDTO(course.getCategory()));
        courseResponse.setLanguage(mapToLanguageDTO(course.getLanguage()));
        courseResponse.setSections(course.getSections().stream().map(section -> mapToSectionResponse(section)).collect(Collectors.toList()));
        courseResponse.setReviews(course.getReviews().stream().map(review -> mapToReviewDto(review)).collect(Collectors.toList()));
        courseResponse.setNumberOfRating(course.getReviews().size());

        int sumOfRating = course.getReviews().stream().mapToInt(Review::getRating).sum();

        double averageRating = sumOfRating * 1.0 / course.getReviews().size();

        courseResponse.setAverageRating(averageRating);
        courseResponse.setNumberOfStudents(course.getPurchaseRecords().size());
        courseResponse.setNumberOfSections(course.getSections().size());

        int numOfLections = course.getSections().stream().mapToInt(section -> section.getLections().size()).sum();

        courseResponse.setNumberOfLections(numOfLections);

        return courseResponse;
    }

    private UserDto mapToUserDTO(User user) {
        UserDto userDto = new UserDto();
        userDto.setUsername(user.getUsername());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());
        userDto.setAvatar(user.getAvatar());
        userDto.setDateCreated(user.getDateCreated());
        userDto.setEnabled(user.getEnabled());

        return userDto;
    }

    private CategoryDto mapToCategoryDTO(Category category) {
        CategoryDto categoryDto = new CategoryDto();

        categoryDto.setId(category.getId());
        categoryDto.setName(category.getName());

        return categoryDto;
    }

    private LanguageDto mapToLanguageDTO(Language language) {
        LanguageDto languageDto = new LanguageDto();

        languageDto.setId(language.getId());
        languageDto.setName(language.getName());

        return languageDto;
    }

    private LectionDto mapLectionToDto(Lection lection) {
        LectionDto lectionDto = new LectionDto();

        lectionDto.setId(lection.getId());
        lectionDto.setName(lection.getName());
        lectionDto.setDescription(lection.getDescription());
        lectionDto.setVideo(lection.getVideo());

        return lectionDto;
    }

    private SectionDto mapSectionDTO(Section section) {
        SectionDto sectionDto = new SectionDto();

        sectionDto.setId(section.getId());
        sectionDto.setName(section.getName());

        return sectionDto;
    }

    private SectionResponse mapToSectionResponse(Section section) {
        SectionResponse sectionResponse = new SectionResponse();
        sectionResponse.setSection(mapSectionDTO(section));
        sectionResponse.setLections(section.getLections().stream().map(lection -> mapLectionToDto(lection)).collect(Collectors.toList()));

        return sectionResponse;
    }

    private ReviewDto mapToReviewDto(Review review) {
        ReviewDto reviewDto = new ReviewDto();

        reviewDto.setId(review.getId());
        reviewDto.setComment(review.getComment());
        reviewDto.setRating(review.getRating());

        return reviewDto;
    }

    private LocalDate getDate() {
        LocalDate now = LocalDate.now();
        return now;
    }
}
