package com.metropolitan.courseholic.payload;

import lombok.Data;

@Data
public class SignUpDto {

    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String type;

}
