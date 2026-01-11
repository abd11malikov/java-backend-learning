package com.otabek.day23.service;



import com.otabek.day23.dto.CommentResponseDTO;
import com.otabek.day23.dto.PostRequestDTO;
import com.otabek.day23.dto.PostResponseDTO;
import com.otabek.day23.entity.Post;
import com.otabek.day23.entity.User;
import com.otabek.day23.repository.PostRepository;
import com.otabek.day23.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepo;
    private final UserRepository userRepo;
    private final CommentService commentService;

    public PostResponseDTO create(PostRequestDTO postRequestDTO){
        System.out.println(postRequestDTO.getUserId());
        System.out.println(postRequestDTO.getContent());
        User user = userRepo.findById(postRequestDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        Post post = new Post();
        post.setTitle(postRequestDTO.getTitle());
        post.setContent(postRequestDTO.getContent());
        post.setAuthor(user);

        Post saved = postRepo.save(post);

        return mapToResponseDto(saved);
    }

    private PostResponseDTO mapToResponseDto(Post post) {
        PostResponseDTO response = new PostResponseDTO();
        response.setId(post.getId());
        response.setTitle(post.getTitle());
        response.setContent(post.getContent());
        response.setAuthorName(post.getAuthor().getUsername());
        List<CommentResponseDTO> commentResponseDTOs = new ArrayList<>();
        post.getComments().forEach(comment -> commentResponseDTOs.add(commentService.mapToResponseDTO(comment)));
        response.setComments(commentResponseDTOs);
        return response;
    }

    public List<PostResponseDTO> getPostsByUser(long id) {
        User user = userRepo.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        List<Post> posts = user.getPosts();
        List<PostResponseDTO> postResponseDTOS = new ArrayList<>();
        posts.forEach(post -> postResponseDTOS.add(mapToResponseDto(post)));
        return postResponseDTOS;
    }

    public PostResponseDTO getById(long id){
        Post post = postRepo.findById(id).orElseThrow(() -> new RuntimeException("Post not Found"));
        return mapToResponseDto(post);
    }

    public List<PostResponseDTO> getAll(){
        List<Post> all = postRepo.findAll();
        List<PostResponseDTO> dtos = new ArrayList<>();
        all.forEach(post -> dtos.add(mapToResponseDto(post)));
        return dtos;
    }

    public void delete (long id){
        postRepo.delete(postRepo.findById(id).orElseThrow(()->new RuntimeException("Post not found")));
    }
}
