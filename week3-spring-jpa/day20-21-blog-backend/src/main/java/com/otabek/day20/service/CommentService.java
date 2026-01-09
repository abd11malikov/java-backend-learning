package com.otabek.day20.service;

import com.otabek.day20.dto.CommentRequestDTO;
import com.otabek.day20.dto.CommentResponseDTO;
import com.otabek.day20.entity.Comment;
import com.otabek.day20.repository.CommentRepository;
import com.otabek.day20.repository.PostRepository;
import com.otabek.day20.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    public CommentResponseDTO create(CommentRequestDTO resDTO){
        Comment comment = mapToEntity(resDTO);
        Comment saved = commentRepository.save(comment);
        return mapToResponseDTO(saved);
    }

    public void delete (long id){
        if (commentRepository.existsById(id)){
            commentRepository.deleteById(id);
        }else throw new RuntimeException("Comment not found");
    }

    public CommentResponseDTO mapToResponseDTO(Comment saved) {
        CommentResponseDTO commentResponseDTO = new CommentResponseDTO();
        commentResponseDTO.setAuthorName(saved.getAuthor().getUsername());
        commentResponseDTO.setId(saved.getId());
        commentResponseDTO.setText(saved.getText());
        return commentResponseDTO;
    }

    public List<CommentResponseDTO> getAll(){
        List<CommentResponseDTO> allDTO = new ArrayList<>();
        commentRepository.findAll().forEach(comment -> {
            allDTO.add(mapToResponseDTO(comment));
        });
        return allDTO;
    }

    public Comment mapToEntity(CommentRequestDTO resDTO) {
        Comment comment = new Comment();
        comment.setAuthor(userRepository.
                findById(resDTO.getUserId()).orElseThrow(()->new RuntimeException("There is no such user")));
        comment.setPost(postRepository.findById(resDTO.getPostId()).orElseThrow(()-> new RuntimeException("Post not Found")));
        comment.setText(resDTO.getText());
        return comment;
    }

    public CommentResponseDTO get(long id) {
        return mapToResponseDTO(commentRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Comment not found!")));
    }
}
