package com.heldt.pismo.springboottestepismo.infra.mapper.impl;

import com.heldt.pismo.springboottestepismo.core.model.OperationType;
import com.heldt.pismo.springboottestepismo.core.model.Transaction;
import com.heldt.pismo.springboottestepismo.core.port.TransactionEntityMapper;
import com.heldt.pismo.springboottestepismo.infra.database.entity.TransactionEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class TransactionEntityMapperImpl implements TransactionEntityMapper {


    @Override
    public Transaction toModel(TransactionEntity dto) {
        return Transaction.builder()
                .id(dto.getId())
                .accountId(dto.getAccountId())
                .operationType(OperationType.valueOf(dto.getOperationType()))
                .amount(dto.getAmount().abs())
                .eventDate(dto.getEventDate())
                .build();
    }

    @Override
    public TransactionEntity toEntity(Transaction model) {
        return TransactionEntity.builder()
                .id(model.getId())
                .accountId(model.getAccountId())
                .operationType(model.getOperationType().getValue())
                .amount(model.getAmount())
                .eventDate(model.getEventDate())
                .build();
    }

}
