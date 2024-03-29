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
    private UserDto author;
    private CategoryDto category;
    private LanguageDto language;
    private List<SectionResponse> sections;
    private List<ReviewDto> reviews;
    private double averageRating;
    private long numberOfStudents;
    private int numberOfSections;
    private int numberOfLections;
    private int numberOfRatings;
    private double percentOfOneRating;
    private double percentOfTwoRating;
    private double percentOfThreeRating;
    private double percentOfFourRating;
    private double percentOfFiveRating;

}
