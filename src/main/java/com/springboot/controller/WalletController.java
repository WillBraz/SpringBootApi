package com.springboot.controller;

import javax.validation.Valid;

import com.springboot.dto.WalletDTO;
import com.springboot.entity.Wallet;
import com.springboot.response.Response;
import com.springboot.service.WalletService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("wallet")
public class WalletController {
    
    @Autowired    
    private WalletService walletService;

    @PostMapping
    public ResponseEntity<Response<WalletDTO>> create(@Valid @RequestBody WalletDTO walletDTO, BindingResult bindingResult){
       
        Response<WalletDTO> response = new Response<WalletDTO>();
       
        if(bindingResult.hasErrors()) {

            bindingResult.getAllErrors().forEach(r -> response.getErrors().add(r.getDefaultMessage()));

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
       
       Wallet wallet = walletService.save(this.convertDtoForEntity(walletDTO));
        
        response.setData(this.convertEntityForDTO(wallet));

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
        
    }

    private Wallet convertDtoForEntity(WalletDTO walletDTO) {
        
        Wallet wallet = new Wallet();
        
        wallet.setId(walletDTO.getId());
        wallet.setName(walletDTO.getName());
        wallet.setValue(walletDTO.getValue());

        return wallet;
        
    }

    private WalletDTO convertEntityForDTO(Wallet wallet) {
        
        WalletDTO walletDTO = new WalletDTO();
        
        walletDTO.setId(wallet.getId());
        walletDTO.setName(wallet.getName());
        walletDTO.setValue(wallet.getValue());

        return walletDTO;
        
    }
}