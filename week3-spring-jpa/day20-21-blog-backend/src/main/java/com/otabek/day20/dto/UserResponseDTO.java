package com.otabek.day20.dto;


import lombok.Data;

import java.util.List;

@Data
public class UserResponseDTO {
    private long id;
    private String username;
    private List<PostResponseDTO> posts;
}
