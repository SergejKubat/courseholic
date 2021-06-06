package com.metropolitan.courseholic.payload;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ReviewDto {

    private long id;
    private String comment;
    private int rating;
    private LocalDate dateCreated;
    private UserDto creator;

}
