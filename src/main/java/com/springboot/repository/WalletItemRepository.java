package com.springboot.repository;

import com.springboot.entity.WalletItem;

import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletItemRepository extends JpaRepository<WalletItem, Long>{
    
}