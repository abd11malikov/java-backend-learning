package com.otabek.day23.dto;


import lombok.Data;

import java.util.List;

@Data
public class UserResponseDTO {
    private long id;
    private String username;
    private String role;
    private List<PostResponseDTO> posts;
}
