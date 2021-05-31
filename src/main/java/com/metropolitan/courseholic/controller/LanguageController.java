package com.metropolitan.courseholic.controller;

import com.metropolitan.courseholic.payload.LanguageDto;
import com.metropolitan.courseholic.service.LanguageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/languages")
public class LanguageController {

    private LanguageService languageService;

    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public ResponseEntity<LanguageDto> createLanguage(@RequestBody LanguageDto languageDto) {
        return new ResponseEntity<>(languageService.createLanguage(languageDto), HttpStatus.CREATED);
    }

    @GetMapping
    public List<LanguageDto> getAll() {
        return languageService.findAll();
    }

    @GetMapping("/{languageId}")
    public ResponseEntity<LanguageDto> findById(@PathVariable(value = "languageId") int languageId) {
        return new ResponseEntity<>(languageService.findById(languageId), HttpStatus.OK);
    }

}
