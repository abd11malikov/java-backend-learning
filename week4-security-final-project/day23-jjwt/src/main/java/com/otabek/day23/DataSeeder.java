package com.otabek.day23;

import com.otabek.day23.dto.UserRequestDTO;
import com.otabek.day23.entity.Comment;
import com.otabek.day23.entity.Post;
import com.otabek.day23.entity.User;
import com.otabek.day23.repository.CommentRepository;
import com.otabek.day23.repository.PostRepository;
import com.otabek.day23.repository.UserRepository;
import com.otabek.day23.security.JwtUtil;
import com.otabek.day23.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataSeeder implements CommandLineRunner {
    private final UserService userService;
    private final UserRepository userRepository;
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    private final JwtUtil jwtUtil;


    @Override
    public void run(String... args) throws Exception {

        String token = jwtUtil.generateToken("otabek_test");
        System.out.println("🎟️ GENERATED TOKEN: " + token);

        String user = jwtUtil.extractUsername(token);
        System.out.println("👤 EXTRACTED USER: " + user);

        if (userRepository.count()==0){
            UserRequestDTO u1=new UserRequestDTO("otabek","otabek2006");
            UserRequestDTO u2=new UserRequestDTO("oybek","oybek2007");
            UserRequestDTO u3=new UserRequestDTO("ozodbek","ozodbek2009");

            userService.createUser(u1);
            userService.createUser(u2);
            userService.createUser(u3);

//            Post p1 = new Post("hello","Hello world",u2);
//            Post p2 = new Post("Bye","Bye world",u2);
//            Post p3 = new Post("Bye","Bye world",u3);
//            Post post1 = new Post("Java is fun", "I learned Spring Boot!", u1);
//            Post post2 = new Post("Relationships", "OneToMany is cool.", u1);
//            postRepository.saveAll(Arrays.asList(p1,p2,p3,post1,post2));
//
//            Comment c1 = new Comment("Great job!", post1, u1);
//            Comment c2 = new Comment("Keep going.", post1, u1);
//            Comment c3 = new Comment("Wow!", post2, u1);
//
//            commentRepository.saveAll(Arrays.asList(c1, c2, c3));
            System.out.println("Database successfully seeded");
        }
    }
}
