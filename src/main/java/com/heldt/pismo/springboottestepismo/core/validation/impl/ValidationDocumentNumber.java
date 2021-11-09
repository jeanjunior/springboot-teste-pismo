package com.heldt.pismo.springboottestepismo.core.validation.impl;

import com.heldt.pismo.springboottestepismo.comum.exception.CustomDocumentAlreadyExistsException;
import com.heldt.pismo.springboottestepismo.comum.exception.CustomParameterConstraintException;
import com.heldt.pismo.springboottestepismo.core.model.Account;
import com.heldt.pismo.springboottestepismo.core.port.AccountServiceRepository;
import com.heldt.pismo.springboottestepismo.core.validation.Validation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@AllArgsConstructor
@Service
public class ValidationDocumentNumber implements Validation<Account> {

    private AccountServiceRepository repository;

    @Override
    public void validate(Account account) throws CustomParameterConstraintException {
        log.info("Validate Document number");
        Optional.ofNullable(account.getDocumentNumber())
                .filter(doc -> !validNumber(doc))
                .orElseThrow(() -> new CustomParameterConstraintException("Invalid Account."));

        repository.findByDocumentNumber(account.getDocumentNumber()).ifPresent(
                doc -> {
                    throw new CustomDocumentAlreadyExistsException("Document number already exists.");
                }
        );
        log.info("OK");
    }

    private boolean validNumber(String value) {
        return value != null && value.matches("^/d");
    }

}
