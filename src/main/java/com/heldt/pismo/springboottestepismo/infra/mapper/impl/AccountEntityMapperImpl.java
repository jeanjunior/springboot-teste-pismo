package com.heldt.pismo.springboottestepismo.infra.mapper.impl;

import com.heldt.pismo.springboottestepismo.infra.database.entity.AccountEntity;
import com.heldt.pismo.springboottestepismo.core.port.AccountEntityMapper;
import com.heldt.pismo.springboottestepismo.core.model.Account;
import org.springframework.stereotype.Component;


@Component
public class AccountEntityMapperImpl implements AccountEntityMapper {

    @Override
    public Account toModel(AccountEntity entity) {
        return Account.builder()
                .id(entity.getId())
                .documentNumber(entity.getDocumentNumber())
                .availableCreditLimit(entity.getAvailableCreditLimit())
                .build();
    }

    @Override
    public AccountEntity toEntity(Account model) {
        return AccountEntity.builder()
                .id(model.getId())
                .documentNumber(model.getDocumentNumber())
                .availableCreditLimit(model.getAvailableCreditLimit())
                .build();
    }

}
