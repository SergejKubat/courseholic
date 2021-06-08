package com.metropolitan.courseholic.service.impl;

import com.metropolitan.courseholic.exception.CourseholicAPIException;
import com.metropolitan.courseholic.exception.ResourceNotFoundException;
import com.metropolitan.courseholic.model.Role;
import com.metropolitan.courseholic.model.User;
import com.metropolitan.courseholic.payload.SignUpDto;
import com.metropolitan.courseholic.payload.UserDto;
import com.metropolitan.courseholic.payload.UserResponse;
import com.metropolitan.courseholic.repository.RoleRepository;
import com.metropolitan.courseholic.repository.UserRepository;
import com.metropolitan.courseholic.security.SecurityUtils;
import com.metropolitan.courseholic.service.UserService;
import com.metropolitan.courseholic.service.mapper.DTOMapper;
import com.metropolitan.courseholic.service.mapper.EntityMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private MailService mailService;

    private EntityMapper entityMapper;
    private DTOMapper dtoMapper;

    public UserServiceImpl(UserRepository userRepository, MailService mailService, EntityMapper entityMapper, DTOMapper dtoMapper) {
        this.userRepository = userRepository;
        this.mailService = mailService;
        this.entityMapper = entityMapper;
        this.dtoMapper = dtoMapper;
    }

    @Override
    public UserDto createUser(SignUpDto signUpDto) {
        User user = entityMapper.mapToUserEntitySignUp(signUpDto);

        User newUser = userRepository.save(user);

        mailService.sendCreationEmail(newUser);

        UserDto userResponse = dtoMapper.mapToUserDTO(newUser);

        return userResponse;
    }

    @Override
    public UserResponse getAllUsers(int pageNo, int pageSize, String sortBy, String sortDir) {

        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

        Page<User> users = userRepository.findAll(pageable);

        List<User> listOfUsers = users.getContent();

        List<UserDto> content = listOfUsers.stream().map(user -> dtoMapper.mapToUserDTO(user)).collect(Collectors.toList());

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

        return dtoMapper.mapToUserDTO(user);
    }

    @Override
    public UserDto getUserDetails() {
        User user = userRepository.findById(SecurityUtils.getCurrentUserUsername()).get();

        return dtoMapper.mapToUserDTO(user);
    }

    @Override
    public UserDto updateUser(UserDto userDto, String username) {

        if (!checkUser(username)) {
            throw new CourseholicAPIException(HttpStatus.BAD_REQUEST, "Wrong user.");
        }

        User user = userRepository.findById(username).orElseThrow(() -> new ResourceNotFoundException("User", "username", username));

        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setAvatar(userDto.getAvatar());
        user.setPassword(userDto.getPassword());

        User updatedUser = userRepository.save(user);

        return dtoMapper.mapToUserDTO(updatedUser);
    }

    @Override
    public UserDto uploadAvatar(String username, String avatarUrl) {
        if (!checkUser(username)) {
            throw new CourseholicAPIException(HttpStatus.BAD_REQUEST, "Wrong user.");
        }

        User user = userRepository.findById(username).orElseThrow(() -> new ResourceNotFoundException("User", "username", username));

        user.setAvatar(avatarUrl);

        User updatedUser = userRepository.save(user);

        return dtoMapper.mapToUserDTO(updatedUser);
    }

    @Override
    public void deleteUser(String username) {

        if (!checkUser(username)) {
            throw new CourseholicAPIException(HttpStatus.BAD_REQUEST, "Wrong user.");
        }

        User user = userRepository.findById(username).orElseThrow(() -> new ResourceNotFoundException("User", "username", username));
        userRepository.delete(user);
    }

    private boolean checkUser(String username) {
        User user = userRepository.findById(SecurityUtils.getCurrentUserUsername()).get();

        return user.getUsername().equals(username);
    }

}
