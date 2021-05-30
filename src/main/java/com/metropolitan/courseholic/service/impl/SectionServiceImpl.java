package com.metropolitan.courseholic.service.impl;

import com.metropolitan.courseholic.exception.CourseholicAPIException;
import com.metropolitan.courseholic.exception.ResourceNotFoundException;
import com.metropolitan.courseholic.model.Course;
import com.metropolitan.courseholic.model.Section;
import com.metropolitan.courseholic.payload.SectionDto;
import com.metropolitan.courseholic.payload.SectionResponse;
import com.metropolitan.courseholic.repository.CourseRepository;
import com.metropolitan.courseholic.repository.SectionRepository;
import com.metropolitan.courseholic.service.SectionService;
import com.metropolitan.courseholic.service.mapper.DTOMapper;
import com.metropolitan.courseholic.service.mapper.EntityMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SectionServiceImpl implements SectionService {

    private SectionRepository sectionRepository;
    private CourseRepository courseRepository;

    private EntityMapper entityMapper;
    private DTOMapper dtoMapper;

    public SectionServiceImpl(SectionRepository sectionRepository, CourseRepository courseRepository, EntityMapper entityMapper, DTOMapper dtoMapper) {
        this.sectionRepository = sectionRepository;
        this.courseRepository = courseRepository;
        this.entityMapper = entityMapper;
        this.dtoMapper = dtoMapper;
    }

    @Override
    public SectionDto createSection(long courseId, SectionDto sectionDto) {
        Section section = entityMapper.mapToSectionEntity(sectionDto);

        Course course = courseRepository.findById(courseId).orElseThrow(() -> new ResourceNotFoundException("Course", "id", String.valueOf(courseId)));

        section.setCourse(course);

        Section newSection = sectionRepository.save(section);

        SectionDto sectionResponse = dtoMapper.mapToSectionDTO(newSection);

        return sectionResponse;
    }

    @Override
    public List<SectionResponse> findAllByCourseId(long courseId) {
        List<Section> sections = sectionRepository.findAllByCourseId(courseId);

        return sections.stream().map(section -> dtoMapper.mapToSectionResponse(section)).collect(Collectors.toList());
    }

    @Override
    public SectionResponse findById(long courseId, long sectionId) {
        checkSection(courseId, sectionId);

        SectionResponse sectionResponse = dtoMapper.mapToSectionResponse(sectionRepository.findById(sectionId).get());

        return sectionResponse;
    }

    @Override
    public SectionDto updateSection(long courseId, long sectionId, SectionDto sectionDto) {
        checkSection(courseId, sectionId);

        Section section = sectionRepository.findById(sectionId).get();

        section.setName(sectionDto.getName());

        Section updatedSection = sectionRepository.save(section);

        SectionDto sectionResponse = dtoMapper.mapToSectionDTO(updatedSection);

        return sectionResponse;
    }

    @Override
    public void deleteSection(long courseId, long sectionId) {
        checkSection(courseId, sectionId);

        sectionRepository.delete(sectionRepository.findById(sectionId).get());
    }

    private void checkSection(long courseId, long sectionId) {
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new ResourceNotFoundException("Course", "id", String.valueOf(courseId)));
        Section section = sectionRepository.findById(sectionId).orElseThrow(() -> new ResourceNotFoundException("Section", "id", String.valueOf(sectionId)));

        if (section.getCourse().getId() != course.getId()) {
            throw new CourseholicAPIException(HttpStatus.BAD_REQUEST, "Section does not belong to course.");
        }
    }

}