package com.metropolitan.courseholic.service;

import com.metropolitan.courseholic.payload.SearchDto;

import java.util.List;

public interface SearchService {

    List<SearchDto> getAllResults(String query);

}
