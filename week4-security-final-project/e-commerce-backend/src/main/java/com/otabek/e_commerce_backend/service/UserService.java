package com.otabek.e_commerce_backend.service;

import com.otabek.e_commerce_backend.dto.request.UserRequestDTO;
import com.otabek.e_commerce_backend.dto.response.UserResponseDTO;
import com.otabek.e_commerce_backend.entity.User;
import com.otabek.e_commerce_backend.enums.Role;
import com.otabek.e_commerce_backend.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public UserResponseDTO create(UserRequestDTO requestDTO){
        if (userRepository.existsByEmail(requestDTO.getEmail())) {
            throw new IllegalArgumentException("Email already in use");
        }
        if (userRepository.existsByUsername(requestDTO.getUsername())) {
            throw new IllegalArgumentException("Username already taken");
        }
        if (userRepository.existsByPhone(requestDTO.getUsername())) {
            throw new IllegalArgumentException("Phone number already taken");
        }
        User user = mapToEntity(requestDTO);
        User savedUser = userRepository.save(user);
        return mapToResponse(savedUser);
    }

    @Transactional
    public UserResponseDTO update(Long id, UserRequestDTO requestDTO) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));

        user.setFirstName(requestDTO.getFirstName());
        user.setLastName(requestDTO.getLastName());
        user.setPhone(requestDTO.getPhone());
        if (!user.getEmail().equals(requestDTO.getEmail())) {
            if(userRepository.existsByEmail(requestDTO.getEmail())) {
                throw new IllegalArgumentException("Email already in use");
            }
            user.setEmail(requestDTO.getEmail());
        }

        User updatedUser = userRepository.save(user);
        return mapToResponse(updatedUser);
    }

    public UserResponseDTO getById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));
        return mapToResponse(user);
    }

    public List<UserResponseDTO> getAll() {
        return userRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete(Long id) {
        if (!userRepository.existsById(id)) {
            throw new EntityNotFoundException("User not found with id: " + id);
        }
        userRepository.deleteById(id);
    }


    public User mapToEntity(UserRequestDTO requestDTO){
        return User.builder()
                .username(requestDTO.getUsername())
                .firstName(requestDTO.getFirstName())
                .lastName(requestDTO.getLastName())
                .phone(requestDTO.getPhone())
                .email(requestDTO.getEmail())
                .password(passwordEncoder.encode(requestDTO.getPassword()))
                .role(Role.CUSTOMER)
                .enabled(true)
                .build();
    }

    public UserResponseDTO mapToResponse(User user){
        return UserResponseDTO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .phone(user.getPhone())
                .email(user.getEmail())
                .role(user.getRole().name())
                .build();
    }
}
