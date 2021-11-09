package com.heldt.pismo.springboottestepismo.infra.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionPostDTO {

    private Long accountId;

    private Integer operationType;

    private BigDecimal amount;

}
