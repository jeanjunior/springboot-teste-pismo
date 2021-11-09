package com.heldt.pismo.springboottestepismo.core.service.impl;

import com.heldt.pismo.springboottestepismo.comum.exception.CustomParameterConstraintException;
import com.heldt.pismo.springboottestepismo.core.model.Transaction;
import com.heldt.pismo.springboottestepismo.core.port.CalculateAmountTransaction;
import com.heldt.pismo.springboottestepismo.core.port.TransactionServiceRepository;
import com.heldt.pismo.springboottestepismo.core.port.TransactionService;
import com.heldt.pismo.springboottestepismo.core.port.ValidationTransactionService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Slf4j
@AllArgsConstructor
@Service
public class TransactionServiceImpl implements TransactionService {

    private TransactionServiceRepository repository;
    private ValidationTransactionService validationTransactionService;
    private CalculateAmountTransaction calculate;

    @Override
    public Optional<Transaction> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Transaction save(Transaction transaction) throws CustomParameterConstraintException {
        log.info("Inicio do save da transaction");
        validationTransactionService.validate(transaction);

        log.info("Fez as validações, vai chamar o repositório para salvar");
        transaction.setEventDate(LocalDateTime.now());
        calculate.calculate(transaction);
        return repository.save(transaction);
    }

}
