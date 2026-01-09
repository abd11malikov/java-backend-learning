package com.otabek.day20.controller;

import com.otabek.day20.dto.PostRequestDTO;
import com.otabek.day20.dto.PostResponseDTO;
import com.otabek.day20.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping
    public ResponseEntity<List<PostResponseDTO>> get() {
        return ResponseEntity.ok(postService.getAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<PostResponseDTO> getById(@PathVariable long id) {
        return ResponseEntity.ok(postService.getById(id));
    }

    @PostMapping
    public ResponseEntity<PostResponseDTO> post(@RequestBody PostRequestDTO postRequestDTO) {
        return ResponseEntity.status(201).body(postService.create(postRequestDTO));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable long id) {
        postService.delete(id);
        return ResponseEntity.status(204).body("Successfully deleted");
    }

}
