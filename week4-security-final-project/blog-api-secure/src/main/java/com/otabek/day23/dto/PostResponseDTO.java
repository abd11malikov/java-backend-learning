package com.otabek.day23.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PostResponseDTO {
    private long id;
    private String title;
    private String content;
    private String authorName;
    private List<CommentResponseDTO> comments;
}
