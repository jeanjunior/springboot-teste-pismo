package com.heldt.pismo.springboottestepismo.core.port;

import com.heldt.pismo.springboottestepismo.infra.dto.TransactionDTO;
import com.heldt.pismo.springboottestepismo.infra.dto.TransactionPostDTO;
import com.heldt.pismo.springboottestepismo.core.model.Transaction;

public interface TransactionDtoMapper {

    Transaction toModel(TransactionDTO dto);

    Transaction toModel(TransactionPostDTO dto);

    TransactionDTO toDto(Transaction model);

}
