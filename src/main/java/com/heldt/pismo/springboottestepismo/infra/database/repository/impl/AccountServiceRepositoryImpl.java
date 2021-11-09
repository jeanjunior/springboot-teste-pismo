package com.heldt.pismo.springboottestepismo.infra.database.repository.impl;

import com.heldt.pismo.springboottestepismo.core.model.Account;
import com.heldt.pismo.springboottestepismo.core.port.AccountEntityMapper;
import com.heldt.pismo.springboottestepismo.core.port.AccountRepository;
import com.heldt.pismo.springboottestepismo.core.port.AccountServiceRepository;
import com.heldt.pismo.springboottestepismo.infra.database.entity.AccountEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@AllArgsConstructor
@Service
public class AccountServiceRepositoryImpl implements AccountServiceRepository {

    private AccountRepository repository;
    private AccountEntityMapper mapper;

    @Override
    public Optional<Account> findById(Long id) {
        return repository.findById(id)
                .map(e -> mapper.toModel(e));
    }

    @Override
    public Optional<Account> findByDocumentNumber(String documentNumber) {
        return repository.findByDocumentNumber(documentNumber)
                .map(e -> mapper.toModel(e));
    }

    @Override
    public Account save(Account model) {
        AccountEntity entity = mapper.toEntity(model);
        return mapper.toModel(repository.save(entity));
    }

}
