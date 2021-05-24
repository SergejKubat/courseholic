package com.metropolitan.courseholic.service.impl;

import com.metropolitan.courseholic.model.User;
import com.metropolitan.courseholic.payload.UserDto;
import com.metropolitan.courseholic.repository.UserRepository;
import com.metropolitan.courseholic.service.UserService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;


    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = new User();

        LocalDate now = LocalDate.now();

        user.setUsername(userDto.getUsername());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setAvatar(userDto.getAvatar());
        user.setDateCreated(now);
        user.setPassword(userDto.getPassword());
        user.setEnabled(userDto.isEnabled());
        user.setAuthorities("STUDENT");

        User newCourse = userRepository.save(user);

        UserDto userResponse = new UserDto();

        userResponse.setUsername(newCourse.getUsername());
        userResponse.setFirstName(newCourse.getFirstName());
        userResponse.setLastName(newCourse.getLastName());
        userResponse.setEmail(newCourse.getEmail());
        userResponse.setAvatar(newCourse.getAvatar());
        userResponse.setDateCreated(newCourse.getDateCreated());
        userResponse.setPassword(newCourse.getPassword());
        userResponse.setEnabled(newCourse.getEnabled());

        return userResponse;
    }

}
