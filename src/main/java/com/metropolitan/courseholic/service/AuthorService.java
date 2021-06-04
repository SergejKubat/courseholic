package com.metropolitan.courseholic.service;

import com.metropolitan.courseholic.payload.AuthorDto;

public interface AuthorService {

    AuthorDto findByUsername(String username);

}
