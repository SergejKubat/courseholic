package com.metropolitan.courseholic.service.impl;

import com.metropolitan.courseholic.exception.CourseholicAPIException;
import com.metropolitan.courseholic.exception.ResourceNotFoundException;
import com.metropolitan.courseholic.model.Course;
import com.metropolitan.courseholic.model.Lection;
import com.metropolitan.courseholic.model.Section;
import com.metropolitan.courseholic.payload.LectionDto;
import com.metropolitan.courseholic.payload.SectionDto;
import com.metropolitan.courseholic.payload.SectionResponse;
import com.metropolitan.courseholic.repository.CourseRepository;
import com.metropolitan.courseholic.repository.SectionRepository;
import com.metropolitan.courseholic.service.SectionService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SectionServiceImpl implements SectionService {

    private SectionRepository sectionRepository;
    private CourseRepository courseRepository;

    public SectionServiceImpl(SectionRepository sectionRepository, CourseRepository courseRepository) {
        this.sectionRepository = sectionRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public SectionDto createSection(long courseId, SectionDto sectionDto) {
        Section section = mapToEntity(sectionDto);

        Course course = courseRepository.findById(courseId).orElseThrow(() -> new ResourceNotFoundException("Course", "id", String.valueOf(courseId)));

        section.setCourse(course);

        Section newSection = sectionRepository.save(section);

        SectionDto sectionResponse = mapToDTO(newSection);

        return sectionResponse;
    }

    @Override
    public List<SectionResponse> findAllByCourseId(long courseId) {
        List<Section> sections = sectionRepository.findAllByCourseId(courseId);

        return sections.stream().map(section -> mapToSectionResponse(section)).collect(Collectors.toList());
    }

    @Override
    public SectionResponse findById(long courseId, long sectionId) {
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new ResourceNotFoundException("Course", "id", String.valueOf(courseId)));
        Section section = sectionRepository.findById(sectionId).orElseThrow(() -> new ResourceNotFoundException("Section", "id", String.valueOf(sectionId)));

        if (section.getCourse().getId() != course.getId()) {
            throw new CourseholicAPIException(HttpStatus.BAD_REQUEST, "Section does not belong to course.");
        }

        SectionResponse sectionResponse = mapToSectionResponse(section);

        return sectionResponse;
    }

    @Override
    public SectionDto updateSection(long courseId, long sectionId, SectionDto sectionDto) {
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new ResourceNotFoundException("Course", "id", String.valueOf(courseId)));
        Section section = sectionRepository.findById(sectionId).orElseThrow(() -> new ResourceNotFoundException("Section", "id", String.valueOf(sectionId)));

        if (section.getCourse().getId() != course.getId()) {
            throw new CourseholicAPIException(HttpStatus.BAD_REQUEST, "Section does not belong to course.");
        }

        section.setName(sectionDto.getName());

        Section updatedSection = sectionRepository.save(section);

        SectionDto sectionResponse = mapToDTO(updatedSection);

        return sectionResponse;
    }

    @Override
    public void deleteSection(long courseId, long sectionId) {
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new ResourceNotFoundException("Course", "id", String.valueOf(courseId)));
        Section section = sectionRepository.findById(sectionId).orElseThrow(() -> new ResourceNotFoundException("Section", "id", String.valueOf(sectionId)));

        if (section.getCourse().getId() != course.getId()) {
            throw new CourseholicAPIException(HttpStatus.BAD_REQUEST, "Section does not belong to course.");
        }

        sectionRepository.delete(section);
    }

    private SectionDto mapToDTO(Section section) {
        SectionDto sectionDto = new SectionDto();

        sectionDto.setId(section.getId());
        sectionDto.setName(section.getName());

        return sectionDto;
    }

    private SectionResponse mapToSectionResponse(Section section) {
        SectionResponse sectionResponse = new SectionResponse();
        sectionResponse.setSection(mapToDTO(section));
        sectionResponse.setLections(section.getLections().stream().map(lection -> mapLectionToDto(lection)).collect(Collectors.toList()));

        return sectionResponse;
    }

    private LectionDto mapLectionToDto(Lection lection) {
        LectionDto lectionDto = new LectionDto();

        lectionDto.setId(lection.getId());
        lectionDto.setName(lection.getName());
        lectionDto.setDescription(lection.getDescription());
        lectionDto.setVideo(lection.getVideo());

        return lectionDto;
    }

    private Section mapToEntity(SectionDto sectionDto) {
        Section section = new Section();

        section.setName(sectionDto.getName());

        return section;
    }

}
