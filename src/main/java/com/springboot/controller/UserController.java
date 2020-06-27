package com.springboot.controller;

import com.springboot.dto.UserDTO;
import com.springboot.entity.User;
import com.springboot.service.UserService;
import com.springboot.response.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<Response<UserDTO>> createUser(@Validated @RequestBody UserDTO userDTO, BindingResult bindingResult)  {

        Response<UserDTO> responseUserDTO = new Response<UserDTO>();

        if(bindingResult.hasErrors()) {

            bindingResult.getAllErrors().forEach(error -> responseUserDTO.getErrors().add(error.getDefaultMessage()));

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseUserDTO);

        }

         User user = userService.save(this.convertDtoForEntity(userDTO));

         responseUserDTO.setData(this.convertEntityForDto(user));

         return ResponseEntity.status(HttpStatus.CREATED).body(responseUserDTO);
                                    
    }

    private User convertDtoForEntity(UserDTO userDTO){

        User user = new User();
        user.setId(userDTO.getId());
        user.setEmail(userDTO.getEmail());
        user.setName(userDTO.getName());
        user.setPassword(userDTO.getPassword());
    
        return user;
    }

    private UserDTO convertEntityForDto(User user){

        UserDTO userDTO = new UserDTO();

        userDTO.setId(user.getId());
        userDTO.setEmail(user.getEmail());
        userDTO.setName(user.getName());
        userDTO.setPassword(user.getPassword());
    
        return userDTO;
    }
}