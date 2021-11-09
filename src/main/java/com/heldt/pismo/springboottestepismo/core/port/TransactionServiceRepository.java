package com.heldt.pismo.springboottestepismo.core.port;

import com.heldt.pismo.springboottestepismo.core.model.Transaction;

import java.util.Optional;

public interface TransactionServiceRepository {

    Optional<Transaction> findById(Long id);

    Transaction save(Transaction model);

}
