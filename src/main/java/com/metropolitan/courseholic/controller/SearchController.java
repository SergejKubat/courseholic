package com.metropolitan.courseholic.controller;

import com.metropolitan.courseholic.payload.SearchDto;
import com.metropolitan.courseholic.service.SearchService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/search")
public class SearchController {

    private SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping()
    public List<SearchDto> getAllResults(@RequestParam(name = "query") String query) {
        return searchService.getAllResults(query);
    }

}