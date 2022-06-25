package com.nttdata.account.domain.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class UpdateAccountRequest {

    private String numAccount;
    private BigDecimal maintenance;
    private int maxMovement;
    private String type;
    private BigDecimal availableBalance;
    private List<String> customers;
}
