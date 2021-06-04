package com.metropolitan.courseholic.service.impl;

import com.metropolitan.courseholic.exception.CourseholicAPIException;
import com.metropolitan.courseholic.exception.ResourceNotFoundException;
import com.metropolitan.courseholic.model.Role;
import com.metropolitan.courseholic.model.User;
import com.metropolitan.courseholic.payload.AuthorDto;
import com.metropolitan.courseholic.repository.RoleRepository;
import com.metropolitan.courseholic.repository.UserRepository;
import com.metropolitan.courseholic.service.AuthorService;
import com.metropolitan.courseholic.service.mapper.DTOMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;

    private DTOMapper dtoMapper;

    public AuthorServiceImpl(UserRepository userRepository, RoleRepository roleRepository, DTOMapper dtoMapper) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.dtoMapper = dtoMapper;
    }

    @Override
    public AuthorDto findByUsername(String username) {
        User user = userRepository.findById(username).orElseThrow(() -> new ResourceNotFoundException("User", "username", username));
        Role authorRole = roleRepository.findById(2).get();

        if (!user.getRoles().contains(authorRole)) {
            throw new CourseholicAPIException(HttpStatus.BAD_REQUEST, "User is not an author.");
        }

        AuthorDto authorDto = dtoMapper.mapToAuthorDTO(user);

        return authorDto;
    }

}
