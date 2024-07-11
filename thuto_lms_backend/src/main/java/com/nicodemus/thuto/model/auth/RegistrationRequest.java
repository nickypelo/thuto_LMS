package com.nicodemus.thuto.model.auth;

import com.nicodemus.thuto.model.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RegistrationRequest {

    @NotEmpty(message = "Firstname is required.")
    private String firstname;

    @NotEmpty(message = "Lastname is required.")
    private String lastname;

    @Email(message = "Enter correct email format.")
    @NotEmpty(message = "Email is required.")
    private String email;

    @NotEmpty(message = "Password is required.")
    @Size(min = 8, message = "Password should be a minimum of 8 characters")
    private String password;

    @NotEmpty(message = "Specify user role.")
    private Role role;
}
