package com.springboot.dto;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserWalletDTO {
    
    private Long id;

    @NotNull(message = "Informe o id do usuario.")
    private Long users;

    @NotNull(message = "Informe o id da carteira")
    private Long wallet;
}