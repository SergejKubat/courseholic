package com.metropolitan.courseholic.payload;

import lombok.Data;

@Data
public class LectionDto {

    private long id;
    private String name;
    private String description;
    private String video;
    private String length;

}
