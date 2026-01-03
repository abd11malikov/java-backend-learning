package com.otabek.day14_real_api;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataSeeder implements CommandLineRunner {
    private final UserRepository userRepository;

    public DataSeeder(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (userRepository.count() == 0) {
            System.out.println("🌱 Seeding database with dummy data...");

            User u1 = new User("admin_user", "admin@taskflow.com");
            User u2 = new User("tester_otabek", "otabek@test.com");
            User u3 = new User("guest_john", "john@gmail.com");

            userRepository.saveAll(Arrays.asList(u1, u2, u3));
            System.out.println("✅ Database seeded!");
        }
    }
}
