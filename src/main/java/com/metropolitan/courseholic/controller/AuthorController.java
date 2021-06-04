package com.metropolitan.courseholic.controller;

import com.metropolitan.courseholic.payload.AuthorDto;
import com.metropolitan.courseholic.payload.UserDto;
import com.metropolitan.courseholic.service.AuthorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
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

    @GetMapping
    public List<UserDto> getAll() {
        return authorService.findAll();
    }

}
