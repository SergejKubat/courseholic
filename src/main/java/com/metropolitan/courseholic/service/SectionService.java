package com.metropolitan.courseholic.service;

import com.metropolitan.courseholic.payload.SectionDto;
import com.metropolitan.courseholic.payload.SectionResponse;

import java.util.List;

public interface SectionService {

    SectionDto createSection(long courseId, SectionDto sectionDto);

    List<SectionResponse> findAllByCourseId(long courseId);

    SectionResponse findById(long courseId, long sectionId);

    SectionDto updateSection(long courseId, long sectionId, SectionDto sectionDto);

    void deleteSection(long courseId, long sectionId);

}
