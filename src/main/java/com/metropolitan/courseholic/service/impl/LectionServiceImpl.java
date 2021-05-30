package com.metropolitan.courseholic.service.impl;

import com.metropolitan.courseholic.exception.CourseholicAPIException;
import com.metropolitan.courseholic.exception.ResourceNotFoundException;
import com.metropolitan.courseholic.model.Lection;
import com.metropolitan.courseholic.model.Section;
import com.metropolitan.courseholic.payload.LectionDto;
import com.metropolitan.courseholic.repository.LectionRepository;
import com.metropolitan.courseholic.repository.SectionRepository;
import com.metropolitan.courseholic.service.LectionService;
import com.metropolitan.courseholic.service.mapper.DTOMapper;
import com.metropolitan.courseholic.service.mapper.EntityMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LectionServiceImpl implements LectionService {

    private LectionRepository lectionRepository;
    private SectionRepository sectionRepository;

    private EntityMapper entityMapper;
    private DTOMapper dtoMapper;

    public LectionServiceImpl(LectionRepository lectionRepository, SectionRepository sectionRepository, EntityMapper entityMapper, DTOMapper dtoMapper) {
        this.lectionRepository = lectionRepository;
        this.sectionRepository = sectionRepository;
        this.entityMapper = entityMapper;
        this.dtoMapper = dtoMapper;
    }

    @Override
    public LectionDto createLection(long sectionId, LectionDto lectionDto) {
        Lection lection = entityMapper.mapToLectionEntity(lectionDto);

        Section section = sectionRepository.findById(sectionId).orElseThrow(() -> new ResourceNotFoundException("Section", "id", String.valueOf(sectionId)));

        lection.setSection(section);

        Lection newLection = lectionRepository.save(lection);

        LectionDto lectionResponse = dtoMapper.mapToLectionDto(newLection);

        return lectionResponse;
    }

    @Override
    public List<LectionDto> findAllBySectionId(long sectionId) {
        List<Lection> lections = lectionRepository.findAllBySectionId(sectionId);

        return lections.stream().map(lection -> dtoMapper.mapToLectionDto(lection)).collect(Collectors.toList());
    }

    @Override
    public LectionDto findById(long sectionId, long lectionId) {
        checkLection(sectionId, lectionId);

        return dtoMapper.mapToLectionDto(lectionRepository.findById(lectionId).get());
    }

    @Override
    public LectionDto updateLection(long sectionId, long lectionId, LectionDto lectionDto) {
        checkLection(sectionId, lectionId);

        Lection lection = lectionRepository.findById(lectionId).get();

        lection.setName(lection.getName());
        lection.setDescription(lectionDto.getDescription());
        lection.setVideo(lectionDto.getVideo());

        Lection updatedLection = lectionRepository.save(lection);

        LectionDto lectionResponse = dtoMapper.mapToLectionDto(updatedLection);

        return lectionResponse;
    }

    @Override
    public void deleteLection(long sectionId, long lectionId) {
        checkLection(sectionId, lectionId);

        lectionRepository.delete(lectionRepository.findById(lectionId).get());
    }

    private void checkLection(long sectionId, long lectionId) {
        Section section = sectionRepository.findById(sectionId).orElseThrow(() -> new ResourceNotFoundException("Section", "id", String.valueOf(sectionId)));
        Lection lection = lectionRepository.findById(lectionId).orElseThrow(() -> new ResourceNotFoundException("Lection", "id", String.valueOf(lectionId)));

        if (lection.getSection().getId() != section.getId()) {
            throw new CourseholicAPIException(HttpStatus.BAD_REQUEST, "Lection does not belong to section.");
        }
    }

}