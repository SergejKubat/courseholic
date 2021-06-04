package com.metropolitan.courseholic.service.mapper;

import com.metropolitan.courseholic.model.*;
import com.metropolitan.courseholic.payload.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DTOMapper {

    public CategoryDto mapToCategoryDTO(Category category) {
        CategoryDto categoryDto = new CategoryDto();

        categoryDto.setId(category.getId());
        categoryDto.setName(category.getName());
        categoryDto.setImage(category.getImage());

        return categoryDto;
    }

    public LanguageDto mapToLanguageDTO(Language language) {
        LanguageDto languageDto = new LanguageDto();

        languageDto.setId(language.getId());
        languageDto.setName(language.getName());

        return languageDto;
    }

    public LectionDto mapToLectionDto(Lection lection) {
        LectionDto lectionDto = new LectionDto();

        lectionDto.setId(lection.getId());
        lectionDto.setName(lection.getName());
        lectionDto.setDescription(lection.getDescription());
        lectionDto.setVideo(lection.getVideo());

        return lectionDto;
    }

    public ReviewDto mapToReviewDto(Review review) {
        ReviewDto reviewDto = new ReviewDto();

        reviewDto.setId(review.getId());
        reviewDto.setComment(review.getComment());
        reviewDto.setRating(review.getRating());

        return reviewDto;
    }

    public SectionDto mapToSectionDTO(Section section) {
        SectionDto sectionDto = new SectionDto();

        sectionDto.setId(section.getId());
        sectionDto.setName(section.getName());

        return sectionDto;
    }

    public SectionResponse mapToSectionResponse(Section section) {
        SectionResponse sectionResponse = new SectionResponse();
        sectionResponse.setSection(mapToSectionDTO(section));
        sectionResponse.setLections(section.getLections().stream().map(lection -> mapToLectionDto(lection)).collect(Collectors.toList()));

        return sectionResponse;
    }

    public CourseDto mapToCourseDTO(Course course) {
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

    public CourseResponse mapToCourseResponse(Course course) {
        CourseResponse courseResponse = new CourseResponse();

        courseResponse.setCourse(mapToCourseDTO(course));
        courseResponse.setAuthor(mapToUserDTO(course.getUser()));
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

    public UserDto mapToUserDTO(User user) {
        UserDto userDto = new UserDto();
        userDto.setUsername(user.getUsername());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());
        userDto.setProfession(user.getProfession());
        userDto.setDescription(user.getDescription());
        userDto.setAvatar(user.getAvatar());
        userDto.setDateCreated(user.getDateCreated());
        userDto.setEnabled(user.getEnabled());

        return userDto;
    }

    public AuthorDto mapToAuthorDTO(User user) {
        AuthorDto authorDto = new AuthorDto();

        UserDto userDto = mapToUserDTO(user);
        authorDto.setAuthor(userDto);

        List<Course> authorCourses = user.getCourses().stream().collect(Collectors.toList());
        List<CourseResponse> courseResponses = authorCourses.stream().map(course -> mapToCourseResponse(course)).collect(Collectors.toList());
        authorDto.setCourses(courseResponses);

        int numberOfStudents = authorCourses.stream().mapToInt(course -> course.getPurchaseRecords().size()).sum();
        authorDto.setNumberOfStudents(numberOfStudents);

        int numberOfRatings = authorCourses.stream().mapToInt(course -> course.getReviews().size()).sum();
        authorDto.setNumberOfRatings(numberOfRatings);

        return authorDto;
    }

}