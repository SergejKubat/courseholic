package com.metropolitan.courseholic.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseResponse {

    private CourseDto course;
    private UserDto user;
    private CategoryDto category;
    private LanguageDto language;
    private List<SectionResponse> sections;
    private List<ReviewDto> reviews;
    private long numberOfRating;
    private double averageRating;
    private long numberOfStudents;
    private int numberOfSections;
    private int numberOfLections;

}
