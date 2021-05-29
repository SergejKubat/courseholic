package com.metropolitan.courseholic.payload;

import lombok.Data;

@Data
public class ReviewDto {

    private long id;
    private String comment;
    private int rating;

}
