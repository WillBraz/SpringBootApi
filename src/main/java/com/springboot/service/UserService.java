package com.springboot.service;

import java.util.Optional;

import com.springboot.entity.User;

public interface UserService {
    
   public User save(User user);

   public Optional<User> findByEmail(String email);


}