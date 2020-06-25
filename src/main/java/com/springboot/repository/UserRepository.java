package com.springboot.repository;

import java.util.Optional;

import com.springboot.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    
  public Optional<User> findByEmail(String email);  
}