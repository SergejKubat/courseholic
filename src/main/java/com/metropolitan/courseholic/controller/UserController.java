package com.metropolitan.courseholic.controller;

import com.metropolitan.courseholic.payload.UserDto;
import com.metropolitan.courseholic.payload.UserResponse;
import com.metropolitan.courseholic.service.UserService;
import com.metropolitan.courseholic.service.impl.FileStorageService;
import com.metropolitan.courseholic.utils.AppConstants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;
    private FileStorageService fileStorageService;

    public UserController(UserService userService, FileStorageService fileStorageService) {
        this.userService = userService;
        this.fileStorageService = fileStorageService;
    }

    @GetMapping
    public UserResponse getAllUsers(
            @RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = "username", required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir
    ) {
        return userService.getAllUsers(pageNo, pageSize, sortBy, sortDir);
    }

    @GetMapping("/{username}")
    public ResponseEntity<UserDto> getUserByUsername(@PathVariable(name = "username") String username) {
        return ResponseEntity.ok(userService.getUserByUsername(username));
    }

    @PutMapping("/{username}")
    public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable(name = "username") String username) {
        UserDto userResponse = userService.updateUser(userDto, username);

        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/{username}/uploadAvatar")
    public ResponseEntity<UserDto> uploadAvatar(@RequestParam(name = "file") MultipartFile file, @PathVariable(name = "username") String username) {
        String fileName = fileStorageService.storeFile(file);

        String avatarUrl = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/download/")
                .path(fileName)
                .toUriString();

        UserDto userReponse = userService.uploadAvatar(username, avatarUrl);

        return new ResponseEntity<>(userReponse, HttpStatus.OK);
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<String> deleteUser(@PathVariable(name = "username") String username) {
        userService.deleteUser(username);

        return new ResponseEntity<>("User is successfully deleted.", HttpStatus.OK);
    }

}