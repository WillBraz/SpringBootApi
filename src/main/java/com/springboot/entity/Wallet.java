package com.springboot.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NonNull;

@Entity
@Data
public class Wallet implements Serializable {
    
	public Wallet() {
	}

	/**
     *
     */
    private static final long serialVersionUID = 8936955551454333958L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String name;

    @NotNull
    private BigDecimal value;
}