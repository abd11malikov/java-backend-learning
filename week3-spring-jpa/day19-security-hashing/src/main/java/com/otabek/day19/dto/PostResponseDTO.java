package com.otabek.day19.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PostResponseDTO {
    private long id;
    private String title;
    private String body;
    private String authorName;
}
