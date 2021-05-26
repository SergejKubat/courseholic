package com.metropolitan.courseholic.service.impl;

import com.metropolitan.courseholic.model.Language;
import com.metropolitan.courseholic.payload.LanguageDto;
import com.metropolitan.courseholic.repository.LanguageRepository;
import com.metropolitan.courseholic.service.LanguageService;
import org.springframework.stereotype.Service;

@Service
public class LanguageServiceImpl implements LanguageService {

    private LanguageRepository languageRepository;

    public LanguageServiceImpl(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    @Override
    public LanguageDto createLanguage(LanguageDto languageDto) {

        Language language = mapToEntity(languageDto);

        Language newLanguage = languageRepository.save(language);

        LanguageDto languageResponse = mapToDTO(newLanguage);

        return languageResponse;
    }

    private LanguageDto mapToDTO(Language language) {
        LanguageDto languageDto = new LanguageDto();

        languageDto.setId(language.getId());
        languageDto.setName(language.getName());

        return languageDto;
    }

    private Language mapToEntity(LanguageDto languageDto) {
        Language language = new Language();

        language.setName(languageDto.getName());

        return language;
    }

}