package com.metropolitan.courseholic.service.impl;

import com.metropolitan.courseholic.exception.ResourceNotFoundException;
import com.metropolitan.courseholic.model.Course;
import com.metropolitan.courseholic.model.PurchaseRecord;
import com.metropolitan.courseholic.model.User;
import com.metropolitan.courseholic.payload.CourseResponse;
import com.metropolitan.courseholic.payload.PurchaseRecordDto;
import com.metropolitan.courseholic.repository.CourseRepository;
import com.metropolitan.courseholic.repository.PurchaseRecordRepository;
import com.metropolitan.courseholic.repository.UserRepository;
import com.metropolitan.courseholic.security.SecurityUtils;
import com.metropolitan.courseholic.service.PurchaseRecordService;
import com.metropolitan.courseholic.service.mapper.DTOMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PurchaseRecordServiceImpl implements PurchaseRecordService {

    private PurchaseRecordRepository purchaseRecordRepository;
    private UserRepository userRepository;
    private CourseRepository courseRepository;

    private DTOMapper dtoMapper;

    public PurchaseRecordServiceImpl(PurchaseRecordRepository purchaseRecordRepository, UserRepository userRepository, CourseRepository courseRepository, DTOMapper dtoMapper) {
        this.purchaseRecordRepository = purchaseRecordRepository;
        this.userRepository = userRepository;
        this.courseRepository = courseRepository;
        this.dtoMapper = dtoMapper;
    }

    @Override
    public List<CourseResponse> findAllByUsername(String username) {
        List<PurchaseRecord> purchaseRecords = purchaseRecordRepository.findAllByUserUsername(username);

        List<CourseResponse> courseResponses = purchaseRecords.stream().map(purchaseRecord -> dtoMapper.mapToCourseResponse(purchaseRecord.getCourse())).collect(Collectors.toList());

        return courseResponses;
    }

    @Override
    public PurchaseRecordDto createPurchaseRecord(long courseId) {
        User user = userRepository.findById(SecurityUtils.getCurrentUserUsername()).get();
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new ResourceNotFoundException("Course", "id", String.valueOf(courseId)));

        PurchaseRecord newPurchaseRecord = new PurchaseRecord();

        newPurchaseRecord.setUser(user);
        newPurchaseRecord.setCourse(course);
        newPurchaseRecord.setDateCreated(LocalDate.now());

        purchaseRecordRepository.save(newPurchaseRecord);

        return dtoMapper.mapToPurchaseRecordDto(newPurchaseRecord);
    }
}