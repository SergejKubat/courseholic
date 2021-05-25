package com.metropolitan.courseholic.service.impl;

import com.metropolitan.courseholic.exception.ResourceNotFoundException;
import com.metropolitan.courseholic.model.User;
import com.metropolitan.courseholic.payload.UserDto;
import com.metropolitan.courseholic.repository.UserRepository;
import com.metropolitan.courseholic.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = mapToEntity(userDto);

        User newUser = userRepository.save(user);

        UserDto userResponse = mapToDTO(newUser);

        return userResponse;
    }

    @Override
    public List<UserDto> getAllUsers(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);

        Page<User> users = userRepository.findAll(pageable);

        List<User> listOfUsers = users.getContent();

        return listOfUsers.stream().map(user -> mapToDTO(user)).collect(Collectors.toList());
    }

    @Override
    public UserDto getUserByUsername(String username) {
        User user = userRepository.findById(username).orElseThrow(() -> new ResourceNotFoundException("User", "username", username));

        return mapToDTO(user);
    }

    @Override
    public UserDto updateUser(UserDto userDto, String username) {
        User user = userRepository.findById(username).orElseThrow(() -> new ResourceNotFoundException("User", "username", username));

        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setAvatar(userDto.getAvatar());
        user.setPassword(userDto.getPassword());

        User updatedUser = userRepository.save(user);

        return mapToDTO(updatedUser);
    }

    @Override
    public void deleteUser(String username) {
        User user = userRepository.findById(username).orElseThrow(() -> new ResourceNotFoundException("User", "username", username));
        userRepository.delete(user);
    }

    private UserDto mapToDTO(User user) {
        UserDto userDto = new UserDto();

        userDto.setUsername(user.getUsername());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());
        userDto.setAvatar(user.getAvatar());
        userDto.setDateCreated(user.getDateCreated());
        userDto.setEnabled(user.getEnabled());

        return userDto;
    }

    private User mapToEntity(UserDto userDto) {
        User user = new User();

        LocalDate now = LocalDate.now();

        user.setUsername(userDto.getUsername());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setAvatar(userDto.getAvatar());
        user.setDateCreated(now);
        user.setPassword(userDto.getPassword());
        user.setEnabled(true);
        user.setAuthorities("STUDENT");

        return user;
    }

}
