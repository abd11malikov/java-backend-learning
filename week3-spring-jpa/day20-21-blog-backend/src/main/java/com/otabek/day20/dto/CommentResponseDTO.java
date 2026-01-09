package com.otabek.day20.dto;

import lombok.Data;

@Data
public class CommentResponseDTO {
    private Long id;
    private String text;
    private String authorName;
}