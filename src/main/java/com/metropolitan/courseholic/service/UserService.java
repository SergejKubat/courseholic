package com.metropolitan.courseholic.service;

import com.metropolitan.courseholic.payload.UserDto;

import java.util.List;

public interface UserService {

    UserDto createUser(UserDto userDto);

    List<UserDto> getAllUsers(int pageNo, int pageSize);

    UserDto getUserByUsername(String username);

    UserDto updateUser(UserDto userDto, String username);

    void deleteUser(String username);

}
