package com.otabek.day15;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;



    public List<User> getAll(){
        return userRepository.findAll();
    }

    public User createUser(User user){
        if (user.getEmail().contains("@scam.com"))
            throw new RuntimeException("Scammer not allowed");
        return userRepository.save(user);
    }

    public User getUserById(long id){
        return userRepository.findById(id).orElseThrow(()->new RuntimeException("User not found"));
    }

    public void deleteUser(Long id){
        if(!userRepository.existsById(id)) throw new RuntimeException("Cannot delete! User not found");
        userRepository.deleteById(id);
    }

    public User getByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public  List<User> getByEmailDomain(String domain) {
        return userRepository.findByEmailDomain(domain);
    }
}
