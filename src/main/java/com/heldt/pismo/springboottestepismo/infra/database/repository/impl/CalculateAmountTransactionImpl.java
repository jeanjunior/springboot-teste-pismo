package com.heldt.pismo.springboottestepismo.infra.database.repository.impl;

import com.heldt.pismo.springboottestepismo.core.calculate.Calculate;
import com.heldt.pismo.springboottestepismo.core.model.Transaction;
import com.heldt.pismo.springboottestepismo.infra.database.entity.TransactionEntity;
import com.heldt.pismo.springboottestepismo.core.model.OperationType;
import com.heldt.pismo.springboottestepismo.core.port.CalculateAmountTransaction;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Map;

@AllArgsConstructor
@Service
public class CalculateAmountTransactionImpl implements CalculateAmountTransaction {

    private Map<OperationType, Calculate<BigDecimal>> strategies;

    @Override
    public void calculate(Transaction transaction) {
        Calculate<BigDecimal> calc = strategies.get(transaction.getOperationType());
        transaction.setAmount(
                calc.calculate(transaction.getAmount())
        );
    }

}
