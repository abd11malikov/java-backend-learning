package com.otabek.day20.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CommentRequestDTO {
    @NotBlank(message = "Comment text cannot be empty")
    private String text;

    @NotBlank
    private Long userId;

    @NotBlank
    private Long postId;
}