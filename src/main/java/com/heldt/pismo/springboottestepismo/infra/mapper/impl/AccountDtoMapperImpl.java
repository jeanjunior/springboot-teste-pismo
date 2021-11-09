package com.heldt.pismo.springboottestepismo.infra.mapper.impl;

import com.heldt.pismo.springboottestepismo.infra.dto.AccountDTO;
import com.heldt.pismo.springboottestepismo.infra.dto.AccountPostDTO;
import com.heldt.pismo.springboottestepismo.core.port.AccountDtoMapper;
import com.heldt.pismo.springboottestepismo.core.model.Account;
import org.springframework.stereotype.Component;


@Component
public class AccountDtoMapperImpl implements AccountDtoMapper {

    @Override
    public Account toModel(AccountDTO dto) {
        return Account.builder()
                .id(dto.getId())
                .documentNumber(dto.getDocumentNumber())
                .build();
    }

    @Override
    public Account toModel(AccountPostDTO dto) {
        return Account.builder()
                .documentNumber(dto.getDocumentNumber())
                .build();
    }

    @Override
    public AccountDTO toDto(Account model) {
        return AccountDTO.builder()
                .id(model.getId())
                .documentNumber(model.getDocumentNumber())
                .build();
    }

}
