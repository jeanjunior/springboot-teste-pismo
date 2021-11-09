package com.heldt.pismo.springboottestepismo.core.port;

import com.heldt.pismo.springboottestepismo.comum.exception.CustomParameterConstraintException;
import com.heldt.pismo.springboottestepismo.core.model.Transaction;

public interface ValidationTransactionService {

    void validate(Transaction transaction) throws CustomParameterConstraintException;

}
