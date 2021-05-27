package com.metropolitan.courseholic.payload;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
public class UserDto {

    @NotEmpty(message = "Username should not be empty")
    @Size(min = 3, message = "Username should have at least 3 characters")
    private String username;
    @NotEmpty(message = "First name should not be empty")
    @Size(min = 2, message = "First name should have at least 2 characters")
    private String firstName;
    @NotEmpty(message = "Last name should not be empty")
    @Size(min = 2, message = "Last name should have at least 2 characters")
    private String lastName;
    @NotEmpty(message = "Email should not be empty")
    @Email
    private String email;
    private String avatar;
    private LocalDate dateCreated;
    @NotEmpty(message = "Password should not be empty")
    @Size(min = 6, message = "Password should have at least 6 characters")
    private String password;
    private boolean enabled;

}
