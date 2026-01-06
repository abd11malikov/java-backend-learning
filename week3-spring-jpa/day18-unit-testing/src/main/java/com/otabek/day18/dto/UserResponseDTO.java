package com.otabek.day18.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserResponseDTO {
    private long id;
    private String username;
    private String email;
    private List<PostResponseDTO> posts;
}
