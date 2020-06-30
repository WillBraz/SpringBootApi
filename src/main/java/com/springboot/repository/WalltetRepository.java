package com.springboot.repository;

import com.springboot.entity.Wallet;

import org.springframework.data.jpa.repository.JpaRepository;

public interface WalltetRepository extends JpaRepository<Wallet, Long> {
    
}