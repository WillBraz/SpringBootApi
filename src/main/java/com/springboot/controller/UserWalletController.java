package com.springboot.controller;

import javax.validation.Valid;

import com.springboot.dto.UserWalletDTO;
import com.springboot.entity.User;
import com.springboot.entity.UserWallet;
import com.springboot.entity.Wallet;
import com.springboot.response.Response;
import com.springboot.service.UserWalletService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user-wallet")
public class UserWalletController {
    
    @Autowired
    private UserWalletService userWalletService;

    @PostMapping
    public ResponseEntity<Response<UserWalletDTO>> create(@Valid @RequestBody UserWalletDTO userWalletDTO, BindingResult bindingResult) {

        Response<UserWalletDTO> response = new Response<UserWalletDTO>();

        if (bindingResult.hasErrors()) {

            bindingResult.getAllErrors().forEach(r -> response.getErrors().add(r.getDefaultMessage()));

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

        UserWallet userWallet = userWalletService.save(this.convertDTOForEntity(userWalletDTO));

        response.setData(this.convertEntityForDto(userWallet));

       return ResponseEntity.status(HttpStatus.CREATED).body(response);
       
    }

    private UserWallet convertDTOForEntity(UserWalletDTO userWalletDTO) {

        User user = new User();
        user.setId(userWalletDTO.getUsers());

        Wallet wallet = new Wallet();
        wallet.setId(userWalletDTO.getWallet());

        UserWallet userWallet = new UserWallet();        
        userWallet.setId(userWalletDTO.getId());
        userWallet.setUsers(user);
        userWallet.setWallet(wallet);
        
        return userWallet;

    }

    private UserWalletDTO convertEntityForDto(UserWallet userWallet) {

        UserWalletDTO userWalletDTO = new UserWalletDTO();
        userWalletDTO.setId(userWallet.getId());
        userWalletDTO.setUsers(userWallet.getUsers().getId());
        userWalletDTO.setWallet(userWallet.getWallet().getId());

        return userWalletDTO;
    }
}