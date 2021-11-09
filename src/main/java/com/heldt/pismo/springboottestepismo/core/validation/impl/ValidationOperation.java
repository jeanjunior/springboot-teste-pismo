package com.heldt.pismo.springboottestepismo.core.validation.impl;

import com.heldt.pismo.springboottestepismo.comum.exception.CustomParameterConstraintException;
import com.heldt.pismo.springboottestepismo.core.model.Transaction;
import com.heldt.pismo.springboottestepismo.core.validation.Validation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ValidationOperation implements Validation<Transaction> {

    @Override
    public void validate(Transaction transaction) throws CustomParameterConstraintException {
        log.info("Validate Operation");
        if (transaction.getOperationType() == null) {
            throw new CustomParameterConstraintException("Invalid Operation.");
        }
        log.info("OK");
    }

}
