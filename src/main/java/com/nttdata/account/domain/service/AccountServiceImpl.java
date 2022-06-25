package com.nttdata.account.domain.service;

import com.nttdata.account.exception.AccountNotFoundException;
import com.nttdata.account.infraestructure.data.document.Account;
import com.nttdata.account.infraestructure.data.respository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AccountServiceImpl implements  AccountService{

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Mono<Account> validateAndGetAccount(String id) {
        return accountRepository.findById(id).switchIfEmpty(Mono.error(new AccountNotFoundException(id)));
    }

    @Override
    public Flux<Account> getAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public Mono<Account> saveAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Mono<Void> deleteAccount(Account account) {
        return accountRepository.delete(account);
    }
}
