package com.metropolitan.courseholic.service;

import com.metropolitan.courseholic.payload.CourseResponse;

import java.util.List;

public interface PurchaseRecordService {

    List<CourseResponse> findAllByUsername(String username);

}
