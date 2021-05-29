package com.metropolitan.courseholic.service;


import com.metropolitan.courseholic.payload.LectionDto;

import java.util.List;

public interface LectionService {

    LectionDto createLection(long sectionId, LectionDto lectionDto);

    List<LectionDto> findAllBySectionId(long sectionId);

    LectionDto findById(long sectionId, long lectionId);

    LectionDto updateLection(long sectionId, long lectionId, LectionDto lectionDto);

    void deleteLection(long sectionId, long lectionId);

}
