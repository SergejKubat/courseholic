package com.metropolitan.courseholic.payload;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PurchaseRecordDto {

    private String username;
    private long courseId;
    private LocalDate dateCreated;

}
