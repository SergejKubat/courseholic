package com.metropolitan.courseholic.payload;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
public class CourseDto {

    private long id;
    @NotEmpty(message = "Course name should not be empty")
    @Size(min = 5, message = "Course name should have at least 5 characters")
    private String name;
    @NotEmpty(message = "Course description should not be empty")
    @Size(min = 10, message = "Course description should have at least 10 characters")
    private String description;
    private LocalDate lastUpdated;
    private Double price;
    private String picture;
    private String video;
    private boolean isPublic;

}
