package com.heldt.pismo.springboottestepismo.infra.database.repository.impl;

import com.heldt.pismo.springboottestepismo.infra.database.entity.TransactionEntity;
import com.heldt.pismo.springboottestepismo.core.port.TransactionEntityMapper;
import com.heldt.pismo.springboottestepismo.core.model.Transaction;
import com.heldt.pismo.springboottestepismo.core.port.TransactionRepository;
import com.heldt.pismo.springboottestepismo.core.port.TransactionServiceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@AllArgsConstructor
@Service
public class TransactionServiceRepositoryImpl implements TransactionServiceRepository {

    private TransactionRepository repository;
    private TransactionEntityMapper mapper;

    @Override
    public Optional<Transaction> findById(Long id) {
        return repository.findById(id)
                .map(e -> mapper.toModel(e));
    }

    @Override
    public Transaction save(Transaction model) {
        TransactionEntity entity = mapper.toEntity(model);
        return mapper.toModel(repository.save(entity));
    }

}
