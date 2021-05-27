package com.metropolitan.courseholic.service.impl;

import com.metropolitan.courseholic.exception.ResourceNotFoundException;
import com.metropolitan.courseholic.model.User;
import com.metropolitan.courseholic.payload.UserDto;
import com.metropolitan.courseholic.payload.UserResponse;
import com.metropolitan.courseholic.repository.UserRepository;
import com.metropolitan.courseholic.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    private ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = mapToEntity(userDto);

        User newUser = userRepository.save(user);

        UserDto userResponse = mapToDTO(newUser);

        return userResponse;
    }

    @Override
    public UserResponse getAllUsers(int pageNo, int pageSize, String sortBy, String sortDir) {

        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

        Page<User> users = userRepository.findAll(pageable);

        List<User> listOfUsers = users.getContent();

        List<UserDto> content = listOfUsers.stream().map(user -> mapToDTO(user)).collect(Collectors.toList());

        UserResponse userResponse = new UserResponse();
        userResponse.setContent(content);
        userResponse.setPageNo(users.getNumber());
        userResponse.setPageSize(users.getSize());
        userResponse.setTotalElements(users.getTotalElements());
        userResponse.setTotalPages(users.getTotalPages());
        userResponse.setLast(users.isLast());

        return userResponse;
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
        UserDto userDto = modelMapper.map(user, UserDto.class);

        /*userDto.setUsername(user.getUsername());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());
        userDto.setAvatar(user.getAvatar());
        userDto.setDateCreated(user.getDateCreated());
        userDto.setEnabled(user.getEnabled());*/

        return userDto;
    }

    private User mapToEntity(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);

        LocalDate now = LocalDate.now();

        /*user.setUsername(userDto.getUsername());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setAvatar(userDto.getAvatar());
        user.setDateCreated(now);
        user.setPassword(userDto.getPassword());
        user.setEnabled(true);
        user.setAuthorities("STUDENT");*/

        user.setDateCreated(now);
        user.setAuthorities("STUDENT");

        return user;
    }

}
