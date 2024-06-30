package com.nicodemus.thuto.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
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
    @NotBlank(message = "Firstname cannot be blank.")
    private String firstname;
    @NotEmpty(message = "Lastname is required.")
    @NotBlank(message = "Lastname cannot be blank.")
    private String lastname;
    @NotEmpty(message = "Email is required.")
    @NotBlank(message = "Email cannot be blank.")
    @Email(message = "Enter correct email format.")
    private String email;
    @NotEmpty(message = "Password is required.")
    @NotBlank(message = "Password cannot be blank.")
    @Size(min = 8, message = "Password should be a minimum of 8 characters")
    private String password;
}
