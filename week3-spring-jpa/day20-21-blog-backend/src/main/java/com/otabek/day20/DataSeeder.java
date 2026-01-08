package com.otabek.day20;

import com.otabek.day20.entity.Comment;
import com.otabek.day20.entity.Post;
import com.otabek.day20.entity.User;
import com.otabek.day20.repository.CommentRepository;
import com.otabek.day20.repository.PostRepository;
import com.otabek.day20.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataSeeder implements CommandLineRunner {
    private final UserRepository userRepository;
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    @Override
    public void run(String... args) throws Exception {
        if (userRepository.count()==0){
            User u1=new User("otabek","otabek2006");
            User u2=new User("oybek","oybek2007");
            User u3=new User("ozodbek","ozodbek2009");
            List<User> users = userRepository.saveAll(Arrays.asList(u1, u2, u3));

            System.out.println(users.get(0).getUsername());

            Post p1 = new Post("hello","Hello world",u2);
            Post p2 = new Post("Bye","Bye world",u2);
            Post p3 = new Post("Bye","Bye world",u3);
            Post post1 = new Post("Java is fun", "I learned Spring Boot!", u1);
            Post post2 = new Post("Relationships", "OneToMany is cool.", u1);
            postRepository.saveAll(Arrays.asList(p1,p2,p3,post1,post2));

            Comment c1 = new Comment("Great job!", post1, u1);
            Comment c2 = new Comment("Keep going.", post1, u1);
            Comment c3 = new Comment("Wow!", post2, u1);

            commentRepository.saveAll(Arrays.asList(c1, c2, c3));
            System.out.println("Database successfully seeded");
        }
    }
}
