package com.metropolitan.courseholic.service.impl;

import com.metropolitan.courseholic.model.PurchaseRecord;
import com.metropolitan.courseholic.payload.CourseResponse;
import com.metropolitan.courseholic.repository.PurchaseRecordRepository;
import com.metropolitan.courseholic.service.PurchaseRecordService;
import com.metropolitan.courseholic.service.mapper.DTOMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PurchaseRecordServiceImpl implements PurchaseRecordService {

    private PurchaseRecordRepository purchaseRecordRepository;

    private DTOMapper dtoMapper;

    public PurchaseRecordServiceImpl(PurchaseRecordRepository purchaseRecordRepository, DTOMapper dtoMapper) {
        this.purchaseRecordRepository = purchaseRecordRepository;
        this.dtoMapper = dtoMapper;
    }

    @Override
    public List<CourseResponse> findAllByUsername(String username) {
        List<PurchaseRecord> purchaseRecords = purchaseRecordRepository.findAllByUserUsername(username);

        List<CourseResponse> courseResponses = purchaseRecords.stream().map(purchaseRecord -> dtoMapper.mapToCourseResponse(purchaseRecord.getCourse())).collect(Collectors.toList());

        return courseResponses;
    }
}
