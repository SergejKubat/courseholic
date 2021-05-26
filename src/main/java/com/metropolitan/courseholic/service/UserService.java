package com.metropolitan.courseholic.service;

import com.metropolitan.courseholic.payload.UserDto;
import com.metropolitan.courseholic.payload.UserResponse;

public interface UserService {

    UserDto createUser(UserDto userDto);

    UserResponse getAllUsers(int pageNo, int pageSize, String sortBy, String sortDir);

    UserDto getUserByUsername(String username);

    UserDto updateUser(UserDto userDto, String username);

    void deleteUser(String username);

}
