package com.heldt.pismo.springboottestepismo.infra.mapper.impl;

import com.heldt.pismo.springboottestepismo.infra.dto.TransactionDTO;
import com.heldt.pismo.springboottestepismo.infra.dto.TransactionPostDTO;
import com.heldt.pismo.springboottestepismo.core.port.TransactionDtoMapper;
import com.heldt.pismo.springboottestepismo.core.model.OperationType;
import com.heldt.pismo.springboottestepismo.core.model.Transaction;
import org.springframework.stereotype.Component;


@Component
public class TransactionDtoMapperImpl implements TransactionDtoMapper {

    @Override
    public Transaction toModel(TransactionDTO dto) {
        return Transaction.builder()
                .id(dto.getId())
                .accountId(dto.getAccountId())
                .operationType(OperationType.valueOf(dto.getOperationType()))
                .amount(dto.getAmount())
                .eventDate(dto.getEventDate())
                .build();
    }

    @Override
    public Transaction toModel(TransactionPostDTO dto) {
        return Transaction.builder()
                .accountId(dto.getAccountId())
                .operationType(OperationType.valueOf(dto.getOperationType()))
                .amount(dto.getAmount())
                .build();
    }

    @Override
    public TransactionDTO toDto(Transaction model) {
        return TransactionDTO.builder()
                .id(model.getId())
                .accountId(model.getAccountId())
                .operationType(model.getOperationType().getValue())
                .amount(model.getAmount())
                .eventDate(model.getEventDate())
                .build();
    }

}
