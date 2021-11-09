package com.heldt.pismo.springboottestepismo.core.port;

import com.heldt.pismo.springboottestepismo.core.model.Transaction;
import com.heldt.pismo.springboottestepismo.infra.database.entity.TransactionEntity;

public interface CalculateAmountTransaction {

    void calculate(Transaction transaction);

}
