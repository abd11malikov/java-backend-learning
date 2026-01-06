package com.otabek.day18;

import com.otabek.day18.dto.UserRequestDTO;
import com.otabek.day18.dto.UserResponseDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    void createUser_successfully(){
        UserRequestDTO dto = new UserRequestDTO();
        dto.setUsername("Otabek");
        dto.setEmail("otabek@java.com");

        User savedUser = new User();
        savedUser.setId(1L);
        savedUser.setUsername("Otabek");
        savedUser.setEmail("otabek@java.com");

        when(userRepository.save(any(User.class))).thenReturn(savedUser);

        UserResponseDTO result = userService.createUser(dto);
        assertNotNull(result);
        assertThat(result.getId()).isEqualTo(1L);
        assertThat(result.getUsername()).isEqualTo("Otabek");

        verify(userRepository, times(1)).save(any(User.class));
    }

    @Test
    void createUser_throwsException_whenEmailIsScam(){
        UserRequestDTO dto = new UserRequestDTO();
        dto.setUsername("Hacker");
        dto.setEmail("hacker@scam.com");

        RuntimeException exception = assertThrows(RuntimeException.class, () -> userService.createUser(dto));

        assertEquals("Scammer not allowed",exception.getMessage());

        verify(userRepository,never()).save(any(User.class));
    }

    @Test
    void deleteUserWhenIdNotFound(){
        when(userRepository.existsById(1L)).thenReturn(false);

        RuntimeException exception = assertThrows(RuntimeException.class, () -> userService.deleteUser(1L));

        assertThat(exception.getMessage()).isEqualTo("Cannot delete! User not found");

        verify(userRepository,never()).deleteById(anyLong());
    }

    @Test
    void getAllWorksWell(){
        User user1 = new User();
        user1.setId(1L);
        user1.setUsername("Otabek");
        user1.setEmail("email@gmail.com");
        user1.setPosts(null);
        User user2 = new User();
        user2.setId(2L);
        user2.setUsername("Oybek");
        user2.setEmail("oybek@gmail.com");
        user2.setPosts(null);
        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        when(userRepository.findAll()).thenReturn(users);
        List<UserResponseDTO> all = userService.getAll();
        assertThat(all.size()).isEqualTo(2);
        assertThat(all.get(0).getId()).isEqualTo(user1.getId());
        assertThat(all.get(0).getUsername()).isEqualTo(user1.getUsername());
        assertThat(all.get(0).getEmail()).isEqualTo(user1.getEmail());
        assertThat(all.get(1).getId()).isEqualTo(user2.getId());
        assertThat(all.get(1).getUsername()).isEqualTo(user2.getUsername());
        assertThat(all.get(1).getEmail()).isEqualTo(user2.getEmail());
    }

    @Test
    void checkEmailIsLowerCased(){
        UserRequestDTO dto = new UserRequestDTO();
        String expectedEmail = "otabek@gmail.com";
        dto.setEmail("OTABEK@gmail.com");
        dto.setUsername("Otabek");
        User user = new User();
        user.setId(1L);
        user.setEmail(dto.getEmail().toLowerCase());
        user.setUsername(dto.getUsername());
        user.setPosts(new ArrayList<>());
        when(userRepository.save(any(User.class))).thenReturn(user);
        UserResponseDTO userResponseDTO = userService.createUser(dto);
        assertThat(userResponseDTO.getEmail()).isEqualTo(expectedEmail);
    }



}
