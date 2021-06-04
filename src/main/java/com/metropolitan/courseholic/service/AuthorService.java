package com.metropolitan.courseholic.service;

import com.metropolitan.courseholic.payload.AuthorDto;
import com.metropolitan.courseholic.payload.UserDto;

import java.util.List;

public interface AuthorService {

    AuthorDto findByUsername(String username);

    List<UserDto> findAll();

}
