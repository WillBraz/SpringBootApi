package com.springboot.repository;

import com.springboot.entity.UserWallet;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserWalletRepository extends JpaRepository<UserWallet, Long>{
    
}