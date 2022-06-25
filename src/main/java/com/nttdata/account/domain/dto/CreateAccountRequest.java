package com.nttdata.account.domain.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@Data
public class CreateAccountRequest {

    @NotBlank
    private String numAccount;
    @NotNull
    private BigDecimal maintenance;
    @NotNull
    private int maxMovement;
    @NotBlank
    private String type;
    @NotNull
    private BigDecimal availableBalance;
    private List<String> customers;
}
