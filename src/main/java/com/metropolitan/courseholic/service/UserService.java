package com.metropolitan.courseholic.service;

import com.metropolitan.courseholic.payload.SignUpDto;
import com.metropolitan.courseholic.payload.UserDto;
import com.metropolitan.courseholic.payload.UserResponse;

public interface UserService {

    UserDto createUser(SignUpDto signUpDto);

    UserResponse getAllUsers(int pageNo, int pageSize, String sortBy, String sortDir);

    UserDto getUserByUsername(String username);

    UserDto getUserByEmail(String email);

    UserDto updateUser(UserDto userDto, String username);

    void deleteUser(String username);

}
