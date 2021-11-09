package com.heldt.pismo.springboottestepismo.core.service.impl;

import com.heldt.pismo.springboottestepismo.comum.exception.CustomDocumentAlreadyExistsException;
import com.heldt.pismo.springboottestepismo.comum.exception.CustomParameterConstraintException;
import com.heldt.pismo.springboottestepismo.core.model.Account;
import com.heldt.pismo.springboottestepismo.core.port.AccountServiceRepository;
import com.heldt.pismo.springboottestepismo.core.port.ValidationAccountService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class AccountServiceImplTest {

    @InjectMocks
    private AccountServiceImpl service;

    @Mock
    private AccountServiceRepository repository;
    @Mock
    private ValidationAccountService validationAccountService;

    @Test
    void findById_ok() {
        Mockito.when(repository.findById(Mockito.anyLong()))
                .thenReturn(Optional.of(mockAccount()));
        Assertions.assertTrue(service.findById(1L).isPresent());
    }

    @Test
    void findById_empty() {
        Mockito.when(repository.findById(Mockito.anyLong()))
                .thenReturn(Optional.empty());
        Assertions.assertTrue(service.findById(1L).isEmpty());
    }

    @Test
    void findByDocumentNumber_ok() {
        Mockito.when(repository.findByDocumentNumber(Mockito.anyString()))
                .thenReturn(Optional.of(mockAccount()));
        Assertions.assertTrue(service.findByDocumentNumber("012346579801").isPresent());
    }

    @Test
    void findByDocumentNumber_empty() {
        Mockito.when(repository.findByDocumentNumber(Mockito.anyString()))
                .thenReturn(Optional.empty());
        Assertions.assertTrue(service.findByDocumentNumber("012346579801").isEmpty());
    }

    @Test
    void save_DoesNotThrow() {
        Mockito.when(repository.save(Mockito.any())).thenReturn(mockAccount());
        Assertions.assertDoesNotThrow(() ->
                service.save(Account.builder().documentNumber("012346579801").build())
        );
    }

    @Test
    void save_ok() {
        Mockito.when(repository.save(Mockito.any())).thenReturn(mockAccount());
        Account saved = service.save(Account.builder().documentNumber("012346579801").build());
        Assertions.assertNotNull(saved);
        Assertions.assertEquals(saved.getId(), 1L);
    }

    @Test
    void save_CustomParameterConstraintException() {
        Mockito.doThrow(CustomParameterConstraintException.class)
                .when(validationAccountService).validate(Mockito.any());
        Assertions.assertThrows(CustomParameterConstraintException.class, () ->
                service.save(Account.builder().documentNumber("document").build())
        );
    }

    @Test
    void save_CustomDocumentAlreadyExistsException() {
        Mockito.doThrow(CustomDocumentAlreadyExistsException.class)
                .when(validationAccountService).validate(Mockito.any());
        Assertions.assertThrows(CustomDocumentAlreadyExistsException.class, () ->
                service.save(Account.builder().documentNumber("012346579801").build())
        );
    }

    private Account mockAccount() {
        return Account.builder()
                .id(1L)
                .documentNumber("012346579801")
                .build();
    }

}