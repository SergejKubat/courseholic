package com.metropolitan.courseholic.service;

import com.metropolitan.courseholic.payload.SignUpDto;
import com.metropolitan.courseholic.payload.UserDto;
import com.metropolitan.courseholic.payload.UserResponse;

import java.util.List;

public interface UserService {

    UserDto createUser(SignUpDto signUpDto);

    UserResponse getAllUsers(int pageNo, int pageSize, String sortBy, String sortDir);

    UserDto getUserByUsername(String username);

    UserDto getUserDetails();

    UserDto updateUser(UserDto userDto, String username);

    UserDto uploadAvatar(String username, String avatarUrl);

    void deleteUser(String username);

}
