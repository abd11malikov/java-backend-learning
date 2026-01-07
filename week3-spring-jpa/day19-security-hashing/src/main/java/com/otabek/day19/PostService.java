package com.otabek.day19;



import com.otabek.day19.dto.PostRequestDTO;
import com.otabek.day19.dto.PostResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepo;
    private final UserRepository userRepo;


    public PostResponseDTO create(PostRequestDTO postRequestDTO){
        System.out.println(postRequestDTO.getUserId());
        System.out.println(postRequestDTO.getBody());
        User user = userRepo.findById(postRequestDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        Post post = new Post();
        post.setTitle(postRequestDTO.getTitle());
        post.setBody(postRequestDTO.getBody());
        post.setUser(user);

        Post saved = postRepo.save(post);

        return mapToResponseDto(saved);
    }

    private PostResponseDTO mapToResponseDto(Post post) {
        PostResponseDTO response = new PostResponseDTO();
        response.setId(post.getId());
        response.setTitle(post.getTitle());
        response.setBody(post.getBody());
        response.setAuthorName(post.getUser().getUsername());
        return response;
    }

    public List<PostResponseDTO> getPostsByUser(long id) {
        User user = userRepo.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        List<Post> posts = user.getPosts();

        List<PostResponseDTO> postResponseDTOS = new ArrayList<>();
        posts.forEach(post -> postResponseDTOS.add(mapToResponseDto(post)));
        return postResponseDTOS;
    }
}
