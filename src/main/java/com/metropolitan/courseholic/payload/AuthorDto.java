package com.metropolitan.courseholic.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDto {

    private UserDto author;
    private List<CourseResponse> courses;
    private int numberOfStudents;
    private int numberOfRatings;

}
