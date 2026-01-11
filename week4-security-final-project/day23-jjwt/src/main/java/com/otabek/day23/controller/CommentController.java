package com.otabek.day23.controller;

import com.otabek.day23.dto.CommentRequestDTO;
import com.otabek.day23.dto.CommentResponseDTO;
import com.otabek.day23.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/comments")
public class CommentController {
    private final CommentService commentService;

    @GetMapping
    public ResponseEntity<List<CommentResponseDTO>> getAll(){
        return ResponseEntity.status(200).body(commentService.getAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<CommentResponseDTO> get(@PathVariable long id) {
        return ResponseEntity.ok(commentService.get(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable long id) {
        commentService.delete(id);
        return ResponseEntity.status(204).body("Deleted successfully");
    }

    @PostMapping
    public ResponseEntity<CommentResponseDTO> post(@RequestBody CommentRequestDTO reqDTO) {
        return ResponseEntity.status(201).body(commentService.create(reqDTO));
    }
}
