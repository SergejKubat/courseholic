package com.metropolitan.courseholic.controller;

import com.metropolitan.courseholic.payload.AuthorDto;
import com.metropolitan.courseholic.service.AuthorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/authors")
public class AuthorController {

    private AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/{username}")
    public AuthorDto getByUsername(@PathVariable(value = "username") String username) {
        return authorService.findByUsername(username);
    }

}
