package com.heldt.pismo.springboottestepismo.core.port;

import com.heldt.pismo.springboottestepismo.infra.dto.AccountDTO;
import com.heldt.pismo.springboottestepismo.infra.dto.AccountPostDTO;
import com.heldt.pismo.springboottestepismo.core.model.Account;

public interface AccountDtoMapper {

    Account toModel(AccountDTO dto);

    Account toModel(AccountPostDTO dto);

    AccountDTO toDto(Account model);

}
