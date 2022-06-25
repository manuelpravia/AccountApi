package com.nttdata.account.infraestructure.data.respository;

import com.nttdata.account.infraestructure.data.document.Account;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface AccountRepository extends ReactiveMongoRepository<Account,String> {
}
