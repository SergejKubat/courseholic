package com.metropolitan.courseholic.service.impl;

import com.metropolitan.courseholic.exception.CourseholicAPIException;
import com.metropolitan.courseholic.exception.ResourceNotFoundException;
import com.metropolitan.courseholic.model.Lection;
import com.metropolitan.courseholic.model.Section;
import com.metropolitan.courseholic.payload.LectionDto;
import com.metropolitan.courseholic.repository.LectionRepository;
import com.metropolitan.courseholic.repository.SectionRepository;
import com.metropolitan.courseholic.service.LectionService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LectionServiceImpl implements LectionService {

    private LectionRepository lectionRepository;
    private SectionRepository sectionRepository;

    public LectionServiceImpl(LectionRepository lectionRepository, SectionRepository sectionRepository) {
        this.lectionRepository = lectionRepository;
        this.sectionRepository = sectionRepository;
    }

    @Override
    public LectionDto createLection(long sectionId, LectionDto lectionDto) {
        Lection lection = mapToEntity(lectionDto);

        Section section = sectionRepository.findById(sectionId).orElseThrow(() -> new ResourceNotFoundException("Section", "id", String.valueOf(sectionId)));

        lection.setSection(section);

        Lection newLection = lectionRepository.save(lection);

        LectionDto lectionResponse = mapToDto(newLection);

        return lectionResponse;
    }

    @Override
    public List<LectionDto> findAllBySectionId(long sectionId) {
        List<Lection> lections = lectionRepository.findAllBySectionId(sectionId);

        return lections.stream().map(lection -> mapToDto(lection)).collect(Collectors.toList());
    }

    @Override
    public LectionDto findById(long sectionId, long lectionId) {
        Section section = sectionRepository.findById(sectionId).orElseThrow(() -> new ResourceNotFoundException("Section", "id", String.valueOf(sectionId)));
        Lection lection = lectionRepository.findById(lectionId).orElseThrow(() -> new ResourceNotFoundException("Lection", "id", String.valueOf(lectionId)));

        if (lection.getSection().getId() != section.getId()) {
            throw new CourseholicAPIException(HttpStatus.BAD_REQUEST, "Lection does not belong to section.");
        }

        return mapToDto(lection);
    }

    @Override
    public LectionDto updateLection(long sectionId, long lectionId, LectionDto lectionDto) {
        Section section = sectionRepository.findById(sectionId).orElseThrow(() -> new ResourceNotFoundException("Section", "id", String.valueOf(sectionId)));
        Lection lection = lectionRepository.findById(lectionId).orElseThrow(() -> new ResourceNotFoundException("Lection", "id", String.valueOf(lectionId)));

        if (lection.getSection().getId() != section.getId()) {
            throw new CourseholicAPIException(HttpStatus.BAD_REQUEST, "Lection does not belong to section.");
        }

        lection.setName(lection.getName());
        lection.setDescription(lectionDto.getDescription());
        lection.setVideo(lectionDto.getVideo());

        Lection updatedLection = lectionRepository.save(lection);

        LectionDto lectionResponse = mapToDto(updatedLection);

        return lectionResponse;
    }

    @Override
    public void deleteLection(long sectionId, long lectionId) {
        Section section = sectionRepository.findById(sectionId).orElseThrow(() -> new ResourceNotFoundException("Section", "id", String.valueOf(sectionId)));
        Lection lection = lectionRepository.findById(lectionId).orElseThrow(() -> new ResourceNotFoundException("Lection", "id", String.valueOf(lectionId)));

        if (lection.getSection().getId() != section.getId()) {
            throw new CourseholicAPIException(HttpStatus.BAD_REQUEST, "Lection does not belong to section.");
        }

        lectionRepository.delete(lection);
    }

    private LectionDto mapToDto(Lection lection) {
        LectionDto lectionDto = new LectionDto();

        lectionDto.setId(lection.getId());
        lectionDto.setName(lection.getName());
        lectionDto.setDescription(lection.getDescription());
        lectionDto.setVideo(lection.getVideo());

        return lectionDto;
    }

    private Lection mapToEntity(LectionDto lectionDto) {
        Lection lection = new Lection();

        lection.setName(lectionDto.getName());
        lection.setDescription(lectionDto.getDescription());
        lection.setVideo(lectionDto.getVideo());

        return lection;
    }
}
