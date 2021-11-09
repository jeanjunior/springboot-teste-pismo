package com.heldt.pismo.springboottestepismo.core.model;

import lombok.*;

import java.math.BigDecimal;

@Data
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    private Long id;

    private String documentNumber;

    private BigDecimal availableCreditLimit;

}
