package com.heldt.pismo.springboottestepismo.core.validation.impl;

import com.heldt.pismo.springboottestepismo.core.model.Account;
import com.heldt.pismo.springboottestepismo.core.model.Transaction;
import com.heldt.pismo.springboottestepismo.core.port.AccountServiceRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;


@ExtendWith(MockitoExtension.class)
class ValidationCreditAccountTest {

    @InjectMocks
    private ValidationCreditAccount validationCreditAccount;

    @Mock
    private AccountServiceRepository repository;

    @Test
    void validate() {
        Mockito.when(repository.findById(Mockito.anyLong()))
                .thenReturn(Optional.of(mockAccount()));

        var transaction = Transaction.builder()
                .accountId(1L)
                .amount(new BigDecimal(30))
                .build();

        Assertions.assertDoesNotThrow(() ->
                validationCreditAccount.validate(transaction)
        );
    }

    @Test
    void validate_ValorIgual() {
        Mockito.when(repository.findById(Mockito.anyLong()))
                .thenReturn(Optional.of(mockAccount()));

        var transaction = Transaction.builder()
                .accountId(1L)
                .amount(new BigDecimal(100))
                .build();

        Assertions.assertDoesNotThrow(() ->
                validationCreditAccount.validate(transaction)
        );
    }

    @Test
    void validate_error() {
        Mockito.when(repository.findById(Mockito.anyLong()))
                .thenReturn(Optional.of(mockAccount()));

        var transaction = Transaction.builder()
                .accountId(1L)
                .amount(new BigDecimal(130))
                .build();

        Assertions.assertThrows(RuntimeException.class, () ->
                validationCreditAccount.validate(transaction)
        );
    }

    private Account mockAccount() {
        return Account.builder()
                .id(1L)
                .documentNumber("012346579801")
                .availableCreditLimit(new BigDecimal(100))
                .build();
    }

}