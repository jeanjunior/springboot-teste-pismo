package com.heldt.pismo.springboottestepismo.infra.database.repository.impl;

import com.heldt.pismo.springboottestepismo.core.model.Account;
import com.heldt.pismo.springboottestepismo.core.port.AccountEntityMapper;
import com.heldt.pismo.springboottestepismo.core.port.AccountRepository;
import com.heldt.pismo.springboottestepismo.infra.database.entity.AccountEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class AccountServiceRepositoryImplTest {

    @InjectMocks
    private AccountServiceRepositoryImpl accountServiceRepository;
    @Mock
    private AccountRepository repository;
    @Mock
    private AccountEntityMapper mapper;

    @Test
    void findById_ok() {
        Mockito.when(repository.findById(Mockito.anyLong()))
                .thenReturn(Optional.of(mockAccountEntity()));
        Mockito.when(mapper.toModel(Mockito.any()))
                .thenReturn(mockAccount());

        Optional<Account> account = accountServiceRepository.findById(1L);
        Assertions.assertTrue(account.isPresent());
        Assertions.assertEquals(account.get().getDocumentNumber(), "012346579801");
    }

    @Test
    void findById_empty() {
        Mockito.when(repository.findById(Mockito.anyLong()))
                .thenReturn(Optional.empty());
        Optional<Account> account = accountServiceRepository.findById(1L);
        Assertions.assertTrue(account.isEmpty());
    }

    private AccountEntity mockAccountEntity() {
        return AccountEntity.builder()
                .id(1L)
                .documentNumber("012346579801")
                .build();
    }

    private Account mockAccount() {
        return Account.builder()
                .id(1L)
                .documentNumber("012346579801")
                .build();
    }

}