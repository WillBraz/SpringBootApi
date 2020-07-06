package com.springboot.service;

import com.springboot.entity.UserWallet;
import com.springboot.repository.UserWalletRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserWalletServiceImpl implements UserWalletService {

    @Autowired
    UserWalletRepository userWalletRepository;

    @Override
    public UserWallet save(UserWallet userWallet) {
       
       return userWalletRepository.save(userWallet);
       
    }
    
}