package com.metropolitan.courseholic.payload;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CourseDto {

    private long id;
    private String name;
    private String description;
    private LocalDate lastUpdated;
    private Double price;
    private String picture;
    private String video;
    private boolean isPublic;

}
