package com.nttdata.account.infraestructure.data.document;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "accounts")
public class Account {
    @Id
    private String id;
    private String numAccount;
    private BigDecimal maintenance;
    private int maxMovement;
    private String type;
    private BigDecimal availableBalance;
    private List<String> customers;
}
