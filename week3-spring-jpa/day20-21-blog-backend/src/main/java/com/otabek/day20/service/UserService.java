package com.otabek.day20.service;

import com.otabek.day20.dto.PostResponseDTO;
import com.otabek.day20.dto.UserRequestDTO;
import com.otabek.day20.dto.UserResponseDTO;
import com.otabek.day20.entity.User;
import com.otabek.day20.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public List<UserResponseDTO> getAll(){
        List<UserResponseDTO> dtos = new ArrayList<>();
        userRepository.findAll().forEach(user -> dtos.add(mapperToResponseDTO(user)));
        return dtos;
    }

    public UserResponseDTO createUser(UserRequestDTO dto){
        User entity = mapperToEntity(dto);
        entity.setPassword(passwordEncoder.encode(dto.getPassword()));
        return mapperToResponseDTO(userRepository.save(entity));
    }

    public UserResponseDTO getUserById(long id){
        return mapperToResponseDTO(userRepository.findById(id).orElseThrow(()->new RuntimeException("User not found")));
    }

    public void deleteUser(Long id){
        if(!userRepository.existsById(id)) {
            throw new RuntimeException("Cannot delete! User not found");
        }else userRepository.deleteById(id);
    }


    public UserResponseDTO mapperToResponseDTO(User user){
        UserResponseDTO dto = new UserResponseDTO();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        if (user.getPosts()!=null) {
            List<PostResponseDTO> postResponseDTOS = user.getPosts().stream().map(
                    post -> {
                        PostResponseDTO postDto = new PostResponseDTO();
                        postDto.setId(post.getId());
                        postDto.setTitle(post.getTitle());
                        postDto.setContent(post.getContent());
                        return postDto;
                    }
            ).toList();

            dto.setPosts(postResponseDTOS);
        }
        return dto;
    }

    public User mapperToEntity(UserRequestDTO dto){
        User user = new User();
        user.setUsername(dto.getUsername());
        return user;
    }
}
