package com.nttdata.account.util.mapper;

import com.nttdata.account.domain.dto.AccountResponse;
import com.nttdata.account.domain.dto.CreateAccountRequest;
import com.nttdata.account.domain.dto.UpdateAccountRequest;
import com.nttdata.account.infraestructure.data.document.Account;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface AccountMapper {

    @Mapping(target = "id",ignore = true)
    Account toAccount(CreateAccountRequest createAccountRequest);

    AccountResponse toAccountResponse(Account account);

    @Mapping(target = "id",ignore = true)
    void updateAccountFromRequest(UpdateAccountRequest updateAccountRequest, @MappingTarget Account account);
}
