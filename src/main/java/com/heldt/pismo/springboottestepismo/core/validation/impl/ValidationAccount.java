package com.heldt.pismo.springboottestepismo.core.validation.impl;

import com.heldt.pismo.springboottestepismo.comum.exception.CustomParameterConstraintException;
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
public class ValidationAccount implements Validation<Transaction> {

    private AccountServiceRepository repository;

    @Override
    public void validate(Transaction transaction) throws CustomParameterConstraintException {
        log.info("Validate Account");
        Optional.ofNullable(transaction.getAccountId())
                .filter((v) -> repository.findById(v).isPresent())
                .orElseThrow(() -> new CustomParameterConstraintException("Invalid Account."));
        log.info("OK");
    }

}
