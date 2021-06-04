package com.metropolitan.courseholic.controller;

import com.metropolitan.courseholic.payload.LectionDto;
import com.metropolitan.courseholic.service.LectionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/")
public class LectionController {

    private LectionService lectionService;

    public LectionController(LectionService lectionService) {
        this.lectionService = lectionService;
    }

    @PreAuthorize("hasAuthority('AUTHOR')")
    @PostMapping("/sections/{sectionId}/lections")
    public ResponseEntity<LectionDto> createLection(@PathVariable(value = "sectionId") long sectionId, @RequestBody LectionDto lectionDto) {
        return new ResponseEntity<>(lectionService.createLection(sectionId, lectionDto), HttpStatus.CREATED);
    }

    @GetMapping("/sections/{sectionId}/lections")
    public List<LectionDto> findLectionsBySectionId(@PathVariable(value = "sectionId") long sectionId) {
        return lectionService.findAllBySectionId(sectionId);
    }

    @GetMapping("/sections/{sectionId}/lections/{lectionId}")
    public ResponseEntity<LectionDto> findLectionById(@PathVariable(value = "sectionId") long sectionId,
                                                      @PathVariable(value = "lectionId") long lectionId) {
        return new ResponseEntity<>(lectionService.findById(sectionId, lectionId), HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('AUTHOR')")
    @PutMapping("/sections/{sectionId}/lections/{lectionId}")
    public ResponseEntity<LectionDto> updateLection(@PathVariable(value = "sectionId") long sectionId,
                                                    @PathVariable(value = "lectionId") long lectionId,
                                                    @RequestBody LectionDto lectionDto) {
        LectionDto updatedLection = lectionService.updateLection(sectionId, lectionId, lectionDto);
        return new ResponseEntity<>(updatedLection, HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('AUTHOR')")
    @DeleteMapping("/sections/{sectionId}/lections/{lectionId}")
    public ResponseEntity<String> deleteLection(@PathVariable(value = "sectionId") long sectionId,
                                                @PathVariable(value = "lectionId") long lectionId) {
        lectionService.deleteLection(sectionId, lectionId);
        return new ResponseEntity<>("Lection deleted successfully", HttpStatus.OK);
    }

}
