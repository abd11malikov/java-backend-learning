package com.otabek.day23.controller;

import com.otabek.day23.dto.AuthRequest;
import com.otabek.day23.dto.UserResponseDTO;
import com.otabek.day23.entity.User;
import com.otabek.day23.security.JwtUtil;
import com.otabek.day23.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;
    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AuthRequest authRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
        );
        UserResponseDTO user = userService.getUserByUsername(authRequest.getUsername());
        String token = jwtUtil.generateToken(authRequest.getUsername(),user.getRole());

        return ResponseEntity.ok(token);
    }
}