package com.springboot.service;

import java.util.Optional;

import com.springboot.entity.User;
import com.springboot.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User save(User user) {
        
        return userRepository.save(user);
    }

    @Override
    public Optional<User> findByEmail(String email) {
      
        return userRepository.findByEmail(email);
    }
    
}