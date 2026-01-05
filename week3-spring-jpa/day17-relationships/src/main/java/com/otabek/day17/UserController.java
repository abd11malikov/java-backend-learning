package com.otabek.day17;

import com.otabek.day17.dto.UserRequestDTO;
import com.otabek.day17.dto.UserResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAll();
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(@Valid @RequestBody UserRequestDTO request){
        return ResponseEntity.status(201).body(userService.createUser(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getById(@PathVariable Long id){
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.ok("Deleted successfully");
    }

    @GetMapping("/search")
    public UserResponseDTO getById(@RequestParam String email){
        return userService.getByEmail(email);
    }

    @GetMapping("/domain")
    public List<UserResponseDTO> getByEmailDomain(@RequestParam String domain){
        return userService.getByEmailDomain(domain);
    }

}
