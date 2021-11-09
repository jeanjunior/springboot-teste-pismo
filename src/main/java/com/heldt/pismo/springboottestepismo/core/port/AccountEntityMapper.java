package com.heldt.pismo.springboottestepismo.core.port;

import com.heldt.pismo.springboottestepismo.infra.database.entity.AccountEntity;
import com.heldt.pismo.springboottestepismo.core.model.Account;

public interface AccountEntityMapper {

    Account toModel(AccountEntity entity);

    AccountEntity toEntity(Account model);

}
