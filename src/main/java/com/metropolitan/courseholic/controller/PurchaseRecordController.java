package com.metropolitan.courseholic.controller;

import com.metropolitan.courseholic.payload.CourseResponse;
import com.metropolitan.courseholic.payload.PurchaseRecordDto;
import com.metropolitan.courseholic.service.PurchaseRecordService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class PurchaseRecordController {

    private PurchaseRecordService purchaseRecordService;

    public PurchaseRecordController(PurchaseRecordService purchaseRecordService) {
        this.purchaseRecordService = purchaseRecordService;
    }

    @CrossOrigin
    @GetMapping("users/{username}/records")
    public List<CourseResponse> findAllByUsername(@PathVariable(name = "username") String username) {
        return purchaseRecordService.findAllByUsername(username);
    }

    @CrossOrigin
    @PostMapping("courses/{courseId}/records")
    public ResponseEntity<PurchaseRecordDto> createPurchaseRecord(@PathVariable(name = "courseId") long courseId) {
        PurchaseRecordDto purchaseRecordDto = purchaseRecordService.createPurchaseRecord(courseId);
        return new ResponseEntity<>(purchaseRecordDto, HttpStatus.CREATED);
    }

}
