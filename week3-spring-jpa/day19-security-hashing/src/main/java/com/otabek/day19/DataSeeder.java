package com.otabek.day19;

import com.otabek.day19.dto.UserRequestDTO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataSeeder implements CommandLineRunner {

    private final UserService userService;

    public DataSeeder(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args) {
        if (userService.getAll().isEmpty()) {
            System.out.println("🌱 Seeding database with dummy data...");

            UserRequestDTO u1 = new UserRequestDTO("admin_user", "admin@taskflow.com","admin2024");
            UserRequestDTO u2 = new UserRequestDTO("tester_otabek", "otabek@test.com","tester2006");
            UserRequestDTO u3 = new UserRequestDTO("guest_john", "john@gmail.com","john45");

            userService.createUser(u1);
            userService.createUser(u2);
            userService.createUser(u3);
            System.out.println("✅ Database seeded!");
        }
    }
}
