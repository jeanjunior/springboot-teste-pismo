package com.heldt.pismo.springboottestepismo.core.service.impl;

import com.heldt.pismo.springboottestepismo.comum.exception.CustomParameterConstraintException;
import com.heldt.pismo.springboottestepismo.core.model.Transaction;
import com.heldt.pismo.springboottestepismo.core.port.ValidationTransactionService;
import com.heldt.pismo.springboottestepismo.core.validation.Validation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@AllArgsConstructor
@Service
public class ValidationTransactionServiceImpl implements ValidationTransactionService {

    private final List<Validation<Transaction>> validations;

    @Override
    public void validate(Transaction transaction) throws CustomParameterConstraintException {
        log.info("Iniciando as validações da transaction");
        validations.forEach(v -> v.validate(transaction));
    }

}
