package com.metropolitan.courseholic.service.impl;

import com.metropolitan.courseholic.exception.ResourceNotFoundException;
import com.metropolitan.courseholic.model.Language;
import com.metropolitan.courseholic.payload.LanguageDto;
import com.metropolitan.courseholic.repository.LanguageRepository;
import com.metropolitan.courseholic.service.LanguageService;
import com.metropolitan.courseholic.service.mapper.DTOMapper;
import com.metropolitan.courseholic.service.mapper.EntityMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LanguageServiceImpl implements LanguageService {

    private LanguageRepository languageRepository;

    private EntityMapper entityMapper;
    private DTOMapper dtoMapper;

    public LanguageServiceImpl(LanguageRepository languageRepository, EntityMapper entityMapper, DTOMapper dtoMapper) {
        this.languageRepository = languageRepository;
        this.entityMapper = entityMapper;
        this.dtoMapper = dtoMapper;
    }

    @Override
    public LanguageDto createLanguage(LanguageDto languageDto) {

        Language language = entityMapper.mapToLanguageEntity(languageDto);

        Language newLanguage = languageRepository.save(language);

        LanguageDto languageResponse = dtoMapper.mapToLanguageDTO(newLanguage);

        return languageResponse;
    }

    @Override
    public LanguageDto findById(int languageId) {
        Language language = languageRepository.findById(languageId).orElseThrow(() -> new ResourceNotFoundException("language", "id", String.valueOf(languageId)));

        return dtoMapper.mapToLanguageDTO(language);
    }

    @Override
    public List<LanguageDto> findAll() {
        return languageRepository.findAll().stream().map(language -> dtoMapper.mapToLanguageDTO(language)).collect(Collectors.toList());
    }

}