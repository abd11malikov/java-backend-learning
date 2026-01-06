package com.otabek.day18;

import com.otabek.day18.dto.PostResponseDTO;
import com.otabek.day18.dto.UserRequestDTO;
import com.otabek.day18.dto.UserResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;



    public List<UserResponseDTO> getAll(){
        List<UserResponseDTO> dtos = new ArrayList<>();
        userRepository.findAll().forEach(user -> dtos.add(mapperToResponseDTO(user)));
        return dtos;
    }

    public UserResponseDTO createUser(UserRequestDTO dto){
        if (dto.getEmail().contains("@scam.com"))
            throw new RuntimeException("Scammer not allowed");
        User entity = mapperToEntity(dto);
        return mapperToResponseDTO(userRepository.save(entity));

    }

    public UserResponseDTO getUserById(long id){
        return mapperToResponseDTO(userRepository.findById(id).orElseThrow(()->new RuntimeException("User not found")));
    }

    public void deleteUser(Long id){
        if(!userRepository.existsById(id)) throw new RuntimeException("Cannot delete! User not found");
        userRepository.deleteById(id);
    }

    public UserResponseDTO getByEmail(String email) {
        User user = userRepository.findByEmail(email);
        if (user==null){
            throw new RuntimeException("User not found by email: "+email);
        }
        return mapperToResponseDTO(user);
    }

    public  List<UserResponseDTO> getByEmailDomain(String domain) {
        List<User> entities = userRepository.findByEmailDomain(domain);
        List<UserResponseDTO> dtoList = new ArrayList<>();
        entities.forEach(user -> dtoList.add(mapperToResponseDTO(user)));
        return dtoList;
    }

    public UserResponseDTO mapperToResponseDTO(User user){
        UserResponseDTO dto = new UserResponseDTO();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setEmail(user.getEmail());
        if (user.getPosts()!=null) {
            List<PostResponseDTO> postResponseDTOS = user.getPosts().stream().map(
                    post -> {
                        PostResponseDTO postDto = new PostResponseDTO();
                        postDto.setId(post.getId());
                        postDto.setTitle(post.getTitle());
                        postDto.setBody(post.getBody());
                        return postDto;
                    }
            ).toList();

            dto.setPosts(postResponseDTOS);
        }
        return dto;
    }

    public User mapperToEntity(UserRequestDTO dto){
        User user = new User();
        user.setEmail(dto.getEmail().toLowerCase());
        user.setUsername(dto.getUsername());
        return user;
    }
}
