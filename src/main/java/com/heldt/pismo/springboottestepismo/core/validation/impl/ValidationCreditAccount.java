package com.heldt.pismo.springboottestepismo.core.validation.impl;

import com.heldt.pismo.springboottestepismo.comum.exception.CustomParameterConstraintException;
import com.heldt.pismo.springboottestepismo.core.model.OperationType;
import com.heldt.pismo.springboottestepismo.core.model.Transaction;
import com.heldt.pismo.springboottestepismo.core.port.AccountServiceRepository;
import com.heldt.pismo.springboottestepismo.core.validation.Validation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@AllArgsConstructor
@Service
public class ValidationCreditAccount implements Validation<Transaction> {

    private AccountServiceRepository repository;

    @Override
    public void validate(Transaction transaction) throws CustomParameterConstraintException {
        log.info("Validate Credit Limit Account");
        Optional.ofNullable(transaction.getAccountId())
                .filter((v) -> {
                            if (transaction.getOperationType() == OperationType.PAGAMENTO) {
                                return true;
                            }
                            var creditLimit = repository.findById(v).get().getAvailableCreditLimit();
                            return creditLimit != null && creditLimit.compareTo(transaction.getAmount()) >= 0;
                        }
                )
                .orElseThrow(() -> new CustomParameterConstraintException("Credit Limit."));
        log.info("OK");
    }

}
