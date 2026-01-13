package com.otabek.day23.service;

import com.otabek.day23.dto.PostResponseDTO;
import com.otabek.day23.dto.UserRequestDTO;
import com.otabek.day23.dto.UserResponseDTO;
import com.otabek.day23.entity.User;
import com.otabek.day23.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
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

    public UserResponseDTO getUserByUsername(String username){
        return mapperToResponseDTO(userRepository.findByUsername(username).orElseThrow(()->new RuntimeException("User not found")));
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
        dto.setRole(user.getRole());
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
        user.setRole(dto.getRole());
        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return org.springframework.security.core.userdetails.User
                .withUsername(user.getUsername())
                .password(user.getPassword())
                .roles(user.getRole())
                .build();
    }
}
