package com.metropolitan.courseholic.repository;

import com.metropolitan.courseholic.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    Optional<User> findUserByUsername(String name);

    Optional<User> findUserByEmail(String email);

}