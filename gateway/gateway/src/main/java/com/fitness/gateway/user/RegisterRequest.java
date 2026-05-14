package com.fitness.gateway.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegisterRequest {
    @NotBlank(message = "Email is Required")
    @Email(message="Invalid email format")
    private String email;

    @NotBlank(message = "password is required")
    @Size(min=6, message="password must have atleast six characters")


    private String keycloakId;
    private String password;
    private String firstname;
    private String lastname;

}
