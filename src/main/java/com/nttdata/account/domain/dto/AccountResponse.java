package com.nttdata.account.domain.dto;

import lombok.Value;

import java.math.BigDecimal;
import java.util.List;

@Value
public class AccountResponse {
    private String id;
    private String numAccount;
    private BigDecimal maintenance;
    private int maxMovement;
    private String type;
    private BigDecimal availableBalance;
    private List<String> customers;
}
