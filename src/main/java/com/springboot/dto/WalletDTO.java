package com.springboot.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WalletDTO {
    
    private Long id;

    @Length(min = 3, message = "O nome deve conter no minimo 3 caracteres.")
    @NotNull(message = "O Nome não pode ser nulo.")
    private String name;

    @NotNull(message = "O valor não pode ser nulo.")
    private BigDecimal value;
}