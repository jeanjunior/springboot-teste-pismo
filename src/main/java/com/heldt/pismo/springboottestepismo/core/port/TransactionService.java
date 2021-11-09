package com.heldt.pismo.springboottestepismo.core.port;

import com.heldt.pismo.springboottestepismo.comum.exception.CustomParameterConstraintException;
import com.heldt.pismo.springboottestepismo.core.model.Transaction;

import java.util.Optional;

public interface TransactionService {

    Optional<Transaction> findById(Long id);

    Transaction save(Transaction transaction) throws CustomParameterConstraintException;

}
