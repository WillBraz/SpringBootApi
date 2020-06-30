package com.springboot.service;

import com.springboot.entity.Wallet;
import com.springboot.repository.WalltetRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * WalletServiceImpl
 */
@Service
public class WalletServiceImpl implements WalletService {

    @Autowired
    WalltetRepository walletRespository;
    
    @Override
    public Wallet save(Wallet wallet) {
        
        return walletRespository.save(wallet);
    }

    
}