package com.springboot.dto;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
public class WalletItemDTO {
    
    private Long id;

    @NotNull(message = "Insira id da carteira.")
    private Long wallet;

    @NotNull(message =  "Insira uma descrição.")
    @Length(message = "A descrição deve ser no minimo 5 caracteres.")
    private String description;
    
    @NotNull(message = "Insira um tipo.")
    private String type;

    @NotNull(message = "Insira um data.")
    private Date date;

    @NotNull(message = "Insira um valor.")
    private BigDecimal value;

}