package com.otabek.day15;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "users_db")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;

    @Column(unique = true,nullable = false)
    private String email;


    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }
}
