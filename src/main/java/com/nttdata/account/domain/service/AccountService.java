package com.nttdata.account.domain.service;

import com.nttdata.account.infraestructure.data.document.Account;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AccountService {

    Mono<Account> validateAndGetAccount(String id);

    Flux<Account> getAccounts();

    Mono<Account> saveAccount(Account account);

    Mono<Void> deleteAccount(Account account);
}
