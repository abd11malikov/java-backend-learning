package com.otabek.day16;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmail(String email);

    @Query("select u from User u where u.email like %?1")
    List<User> findByEmailDomain(String domain);
}
