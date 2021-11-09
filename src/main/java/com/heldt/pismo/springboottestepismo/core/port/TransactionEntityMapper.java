package com.heldt.pismo.springboottestepismo.core.port;

import com.heldt.pismo.springboottestepismo.infra.database.entity.TransactionEntity;
import com.heldt.pismo.springboottestepismo.core.model.Transaction;

public interface TransactionEntityMapper {

    Transaction toModel(TransactionEntity entity);

    TransactionEntity toEntity(Transaction model);

}
