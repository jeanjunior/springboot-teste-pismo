package com.heldt.pismo.springboottestepismo.core.model;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {

    private Long id;

    private Long accountId;

    private OperationType operationType;

    private BigDecimal amount;

    private LocalDateTime eventDate;

}
