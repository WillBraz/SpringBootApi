package com.springboot.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

import lombok.Data;


@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {
    
    private Long id;

    @Email(message = "Email inválido")
    private String email;

    @Length(min = 3, message = "A senha deve conter no mínimo 3 caracteres.")
    private String password;

    @Length(min = 2, max = 50, message = "O nome deve conter entre 2 e 50 caracteres.")
    private String name;

}
