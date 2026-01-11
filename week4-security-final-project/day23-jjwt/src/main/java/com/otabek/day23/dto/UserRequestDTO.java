package com.otabek.day23.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDTO {
    @NotBlank(message = "Username cannot be blank")
    @Size(min = 3,message = "Username at least 3 character")
    String username;
    @NotBlank
    String password;


}
