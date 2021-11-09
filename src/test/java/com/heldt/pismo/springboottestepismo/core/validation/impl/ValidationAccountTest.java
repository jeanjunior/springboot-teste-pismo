package com.heldt.pismo.springboottestepismo.core.validation.impl;

import com.heldt.pismo.springboottestepismo.core.model.Account;
import com.heldt.pismo.springboottestepismo.core.model.OperationType;
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
import java.time.LocalDateTime;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class ValidationAccountTest {

    @InjectMocks
    private ValidationAccount validationAccount;

    @Mock
    private AccountServiceRepository repository;

    @Test
    void validateValid() {
        Mockito.when(repository.findById(Mockito.anyLong())).thenReturn(Optional.of(mockAccount()));
        Assertions.assertDoesNotThrow(() -> validationAccount.validate(mockTransaction()));
    }

    @Test
    void validateNull() {
        Transaction transaction = mockTransaction();
        transaction.setAccountId(null);
        Assertions.assertThrows(RuntimeException.class, () -> validationAccount.validate(transaction));
    }

    @Test
    void validateNotFount() {
        Mockito.when(repository.findById(Mockito.anyLong())).thenReturn(Optional.empty());
        Assertions.assertThrows(RuntimeException.class, () -> validationAccount.validate(mockTransaction()));
    }

    private Account mockAccount() {
        return Account.builder()
                .id(1L)
                .documentNumber("012346579801")
                .build();
    }

    private Transaction mockTransaction() {
        return Transaction.builder()
                .id(1L)
                .accountId(1L)
                .operationType(OperationType.COMPRA_A_VISTA)
                .amount(new BigDecimal(100))
                .eventDate(LocalDateTime.now())
                .build();
    }

}