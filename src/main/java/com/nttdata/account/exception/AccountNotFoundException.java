package com.nttdata.account.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AccountNotFoundException extends RuntimeException{

    public  AccountNotFoundException(String id){
        super(String.format("Account with %s not found",id));
    }
}
