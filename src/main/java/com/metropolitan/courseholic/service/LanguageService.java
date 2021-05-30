package com.metropolitan.courseholic.service;

import com.metropolitan.courseholic.payload.LanguageDto;

import java.util.List;

public interface LanguageService {

    LanguageDto createLanguage(LanguageDto languageDto);

    LanguageDto findById(int languageId);

    List<LanguageDto> findAll();

}
