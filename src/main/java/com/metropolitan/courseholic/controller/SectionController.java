package com.metropolitan.courseholic.controller;

import com.metropolitan.courseholic.payload.SectionDto;
import com.metropolitan.courseholic.payload.SectionResponse;
import com.metropolitan.courseholic.service.SectionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/")
public class SectionController {

    private SectionService sectionService;

    public SectionController(SectionService sectionService) {
        this.sectionService = sectionService;
    }

    @PreAuthorize("hasAuthority('AUTHOR')")
    @PostMapping("/courses/{courseId}/sections")
    public ResponseEntity<SectionDto> createSection(@PathVariable(value = "courseId") long courseId, @RequestBody SectionDto sectionDto) {
        return new ResponseEntity<>(sectionService.createSection(courseId, sectionDto), HttpStatus.CREATED);
    }

    @GetMapping("/courses/{courseId}/sections")
    public List<SectionResponse> findSectionsByCourseId(@PathVariable(value = "courseId") long courseId) {
        return sectionService.findAllByCourseId(courseId);
    }

    @GetMapping("/courses/{courseId}/sections/{sectionId}")
    public ResponseEntity<SectionResponse> findSectionById(@PathVariable(value = "courseId") long courseId,
                                                           @PathVariable(value = "sectionId") long sectionId) {
        return new ResponseEntity<>(sectionService.findById(courseId, sectionId), HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('AUTHOR')")
    @PutMapping("/courses/{courseId}/sections/{sectionId}")
    public ResponseEntity<SectionDto> updateSection(@PathVariable(value = "courseId") long courseId,
                                                    @PathVariable(value = "sectionId") long sectionId,
                                                    @RequestBody SectionDto sectionDto) {
        SectionDto updatedSection = sectionService.updateSection(courseId, sectionId, sectionDto);
        return new ResponseEntity<>(updatedSection, HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('AUTHOR')")
    @DeleteMapping("/courses/{courseId}/sections/{sectionId}")
    public ResponseEntity<String> deleteSection(@PathVariable(value = "courseId") long courseId,
                                               @PathVariable(value = "sectionId") long sectionId) {
        sectionService.deleteSection(courseId, sectionId);
        return new ResponseEntity<>("Section deleted successfully", HttpStatus.OK);
    }

}