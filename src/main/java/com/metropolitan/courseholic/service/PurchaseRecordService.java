package com.metropolitan.courseholic.service;

import com.metropolitan.courseholic.payload.CourseResponse;
import com.metropolitan.courseholic.payload.PurchaseRecordDto;

import java.util.List;

public interface PurchaseRecordService {

    List<CourseResponse> findAllByUsername(String username);

    PurchaseRecordDto createPurchaseRecord(long courseId);

}
