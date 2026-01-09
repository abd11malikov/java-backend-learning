package com.otabek.day20.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PostRequestDTO {
    @NotBlank
    private String title;
    @NotBlank()
    private String content;
    @NotBlank
    private long userId;
}
