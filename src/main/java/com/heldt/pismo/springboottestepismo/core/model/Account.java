package com.heldt.pismo.springboottestepismo.core.model;

import lombok.*;

@Data
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    private Long id;

    private String documentNumber;

}
