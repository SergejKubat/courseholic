package com.metropolitan.courseholic.payload;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserDto {

    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String avatar;
    private LocalDate dateCreated;
    private String password;
    private boolean enabled;

}
