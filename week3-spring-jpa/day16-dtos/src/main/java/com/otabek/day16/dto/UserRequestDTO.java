package com.otabek.day16.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserRequestDTO {
    @NotBlank(message = "username is required")
    @Size(min = 3,message = "Username must be at least 3 character")
    private String username;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email")
    private String email;

}
