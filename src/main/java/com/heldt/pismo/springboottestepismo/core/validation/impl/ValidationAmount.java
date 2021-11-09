package com.heldt.pismo.springboottestepismo.core.validation.impl;

import com.heldt.pismo.springboottestepismo.comum.exception.CustomParameterConstraintException;
import com.heldt.pismo.springboottestepismo.core.model.Transaction;
import com.heldt.pismo.springboottestepismo.core.validation.Validation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Slf4j
@Service
public class ValidationAmount implements Validation<Transaction> {

    @Override
    public void validate(Transaction transaction) throws CustomParameterConstraintException {
        log.info("Validate Amount");
        Optional.ofNullable(transaction.getAmount())
                .filter((v) -> v.compareTo(BigDecimal.ZERO) > 0)
                .orElseThrow(() -> new CustomParameterConstraintException("Invalid Amount."));
        log.info("OK");
    }

}
