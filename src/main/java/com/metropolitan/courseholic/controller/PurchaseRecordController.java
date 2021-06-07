package com.metropolitan.courseholic.controller;

import com.metropolitan.courseholic.payload.CourseResponse;
import com.metropolitan.courseholic.service.PurchaseRecordService;
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

}
