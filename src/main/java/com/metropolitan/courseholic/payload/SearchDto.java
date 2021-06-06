package com.metropolitan.courseholic.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchDto {

    private String authorUsername;
    private long courseId;
    private String courseName;

}