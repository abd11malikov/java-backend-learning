package com.otabek.day14_real_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        User saved = userRepository.save(user);
        return ResponseEntity.status(201).body(saved);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable Long id){

        User user= userRepository.findById(id).orElse(null);
        if (user!=null) return ResponseEntity.ok(user);
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        userRepository.deleteById(id);
        return "Deleted successfully";
    }

    @GetMapping("/search")
    public User getById(@RequestParam String email){
        return userRepository.findByEmail(email);
    }

    @GetMapping("/domain")
    public List<User> getByEmailDomain(@RequestParam String domain){
        return userRepository.findByEmailDomain(domain);
    }
}
