package com.otabek.day17.dto;


import lombok.Data;

@Data
public class PostRequestDTO {
    private String title;
    private String body;
    private long userId;
}
