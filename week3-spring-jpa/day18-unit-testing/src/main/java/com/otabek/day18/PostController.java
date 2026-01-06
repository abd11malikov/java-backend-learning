package com.otabek.day18;

import com.otabek.day18.dto.PostRequestDTO;
import com.otabek.day18.dto.PostResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/post")
public class PostController {
    private final PostService postService;

    @PostMapping
    private PostResponseDTO create(@RequestBody @Valid PostRequestDTO postRequestDTO){
        return postService.create(postRequestDTO);
    }

    @GetMapping
    private List<PostResponseDTO> getPostsByUser(@RequestParam long userId){
        return postService.getPostsByUser(userId);
    }
}
