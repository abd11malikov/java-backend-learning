package com.otabek.day18.dto;


import lombok.Data;

@Data
public class PostRequestDTO {
    private String title;
    private String body;
    private long userId;
}
