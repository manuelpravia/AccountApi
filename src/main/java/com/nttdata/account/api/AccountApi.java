package com.nttdata.account.api;


import com.nttdata.account.domain.dto.AccountResponse;
import com.nttdata.account.domain.dto.CreateAccountRequest;
import com.nttdata.account.domain.dto.UpdateAccountRequest;
import com.nttdata.account.domain.service.AccountService;
import com.nttdata.account.infraestructure.data.document.Account;
import com.nttdata.account.util.mapper.AccountMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/accounts")
public class AccountApi {

    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountMapper accountMapper;

    @GetMapping(produces = MediaType.APPLICATION_NDJSON_VALUE)
    public Flux<AccountResponse> getAccounts(){
        return accountService.getAccounts().map(accountMapper::toAccountResponse);
    }

    @GetMapping("/{id}")
    public Mono<AccountResponse> getAccount(@PathVariable String id){
        return accountService.validateAndGetAccount(id).map(accountMapper::toAccountResponse);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Mono<AccountResponse> createAccount(@Valid @RequestBody CreateAccountRequest createAccountRequest) {
        Account account = accountMapper.toAccount(createAccountRequest);
        return accountService.saveAccount(account).map(accountMapper::toAccountResponse);
    }

    @PatchMapping("/{id}")
    public Mono<AccountResponse> updateAccount(@PathVariable String id,
                                                 @RequestBody UpdateAccountRequest updateAccountRequest) {
        return accountService.validateAndGetAccount(id)
                .doOnSuccess(account -> {
                    accountMapper.updateAccountFromRequest(updateAccountRequest, account);
                    accountService.saveAccount(account).subscribe();
                })
                .map(accountMapper::toAccountResponse);
    }

    @DeleteMapping("/{id}")
    public Mono<AccountResponse> deleteAccount(@PathVariable String id) {
        return accountService.validateAndGetAccount(id)
                .doOnSuccess(account -> accountService.deleteAccount(account).subscribe())
                .map(accountMapper::toAccountResponse);
    }
}
